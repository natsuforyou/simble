/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config;

import com.jesse.framework.config.utils.BaseConfigReader;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.Watcher;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jesse Qian on 16-5-7.
 */
public class FastConfigReader {

    private static Logger logger = LoggerFactory.getLogger(FastConfigReader.class);

    private static boolean localInfoInitialized = false;

    private String connectionString;

    private ZkClient zkClient;

    private Watcher.Event.KeeperState keeperState;

    private static final int CONNECTION_TIMEOUT = 2000;

    private static final int SESSION_TIMEOUT = 30000;

    private DateTime lastTryConnectTime = new DateTime();

    //上次丢失连接, 尝试连接之后， 重新尝试从zk读最新文件的间隔时间（秒）
    private static final int retryZkConnectIntervalSec = 30;

    private static class FastConfigReaderHolder{
        static final FastConfigReader INSTANCE = new FastConfigReader();
    }

    public static FastConfigReader getInstance() {
        return FastConfigReaderHolder.INSTANCE;
    }

    private synchronized void connectZkIfNeed() {
        if (zkClient != null) {
            return;
        }

        try {
            lastTryConnectTime = new DateTime();
            zkClient = new ZkClient(connectionString, SESSION_TIMEOUT, CONNECTION_TIMEOUT);
            keeperState =
        }
    }

    private void init() {
        connectionString = StringUtils.trimToNull(BaseConfigReader.getZkConnectString());

        if (StringUtils.isEmpty(connectionString)) {
            logger.error("connectionString should no be empty");
            return;
        }

        localInfoInitialized = true;

    }
}
