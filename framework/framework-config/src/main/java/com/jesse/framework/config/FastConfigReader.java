/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config;

import com.jesse.framework.config.enums.ConfLocation;
import com.jesse.framework.config.enums.ConfScope;
import com.jesse.framework.config.exception.PropertiesException;
import com.jesse.framework.config.utils.PropertiesReader;
import com.jesse.framework.config.utils.PropertiesPathResolver;
import com.jesse.framework.config.utils.PropertiesUtil;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.Watcher;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jesse Qian on 16-5-7.
 * fast config reader try from zk
 */
public class FastConfigReader {

    private static Logger logger = LoggerFactory.getLogger(FastConfigReader.class);

    private static boolean localInfoInitialized = false;

    private static boolean onlyLocal = false;

    private String connectionString;

    private ZkClient zkClient;

    private Watcher.Event.KeeperState keeperState;

    private static final int CONNECTION_TIMEOUT = 2000;

    private static final int SESSION_TIMEOUT = 30000;

    private DateTime lastTryConnectTime = new DateTime();

    private Map<String, byte[]> cache = new ConcurrentHashMap<>();

    //上次丢失连接, 尝试连接之后， 重新尝试从zk读最新文件的间隔时间（秒）
    private static final int retryZkConnectIntervalSec = 30;

    private static class FastConfigReaderHolder {

        static final FastConfigReader INSTANCE = new FastConfigReader();

        static {
            INSTANCE.init();
        }
    }

    private static FastConfigReader getInstance() {
        return FastConfigReaderHolder.INSTANCE;
    }

    private synchronized void connectZkIfNeed() {
        if (zkClient != null) {
            return;
        }

//        try {
        lastTryConnectTime = new DateTime();
        zkClient = new ZkClient(connectionString, SESSION_TIMEOUT, CONNECTION_TIMEOUT);
        keeperState = Watcher.Event.KeeperState.SyncConnected;
        zkClient.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
                if (state == Watcher.Event.KeeperState.AuthFailed) {
                    logger.error("");
                }
                if (state != Watcher.Event.KeeperState.SaslAuthenticated) {
                    keeperState = state;
                }
            }

            @Override
            public void handleNewSession() throws Exception {

            }

            @Override
            public void handleSessionEstablishmentError(Throwable error) throws Exception {

            }
        });
//        }
    }

    private void init() {
        connectionString = StringUtils.trimToNull(PropertiesReader.getZkConnectString());

        if (StringUtils.isEmpty(connectionString)) {
            logger.error("connectionString should no be empty");
            return;
        }

        onlyLocal = PropertiesReader.isLocal();
        localInfoInitialized = true;

        connectZkIfNeed();

    }

    private boolean needReconnect() {
        return keeperState == Watcher.Event.KeeperState.Disconnected || keeperState == Watcher.Event.KeeperState.Expired;
    }

    private void ensureZkClient() {
        if (!localInfoInitialized) {
            logger.error("localInfoInitialized=false");
            return;
        }
        if (null == zkClient || needReconnect()) {
            if (lastTryConnectTime.plusSeconds(retryZkConnectIntervalSec).isBeforeNow()) {
                connectZkIfNeed();
            }
        }
    }

    private byte[] getData(String path, ConfScope scope) {
        if (StringUtils.isEmpty(path)) {
            throw PropertiesException.instance("");
        }
        if (onlyLocal) {
            String confPath = PropertiesPathResolver.getConfPath(path, scope, ConfLocation.FS);
            return getDataFromLocal(confPath);
        }

        ensureZkClient();
        String confPath = PropertiesPathResolver.getConfPath(path, scope, ConfLocation.ZK);
        if (keeperState == Watcher.Event.KeeperState.ConnectedReadOnly || keeperState == Watcher.Event.KeeperState.SyncConnected) {
            byte[] data = zkClient.readData(confPath);
            cache.put(confPath, data);
            return data;
        } else {
            return getDataFromCache(confPath);
        }
    }

    private byte[] getDataFromLocal(String path) {
        try {
            byte[] data = FileUtils.readFileToByteArray(new File(path));
            return data;
        } catch (IOException e) {

        }
        return null;
    }

    private byte[] getDataFromCache(String path) {
        if (cache.containsKey(path)) {
            return cache.get(path);
        } else {
            return getDataFromLocal(path);
        }
    }

    static Properties getProperties(String path, ConfScope scope) {
        byte[] data = getInstance().getData(path, scope);
        return PropertiesUtil.getProperties(data);
    }
}
