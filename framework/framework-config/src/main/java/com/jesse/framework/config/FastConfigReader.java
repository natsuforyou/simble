/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jesse Qian on 16-5-7.
 */
public class FastConfigReader {

    private static Logger logger = LoggerFactory.getLogger(FastConfigReader.class);

    private ZkClient zkClient;

    private static class FastConfigReaderHolder{
        static final FastConfigReader INSTANCE = new FastConfigReader();
    }

    public static FastConfigReader getInstance() {
        return FastConfigReaderHolder.INSTANCE;
    }

    private void init() {

    }
}
