package org.simble.member.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class MemberServerStarter {

    private static final Logger logger = LoggerFactory.getLogger(MemberServerStarter.class);

    public static void main(String[] args) throws InterruptedException {

        new SpringApplicationBuilder()
                .sources(MemberServerStarter.class)
                .web(false)
                .run(args);

        logger.info("项目启动!");

        new CountDownLatch(1).await();
    }
}
