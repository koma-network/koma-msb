/*
 * Copyright   : KOMA-Network (Indonesia IoT Club)
 * Create by   : Yan Yan Purdiansah
 * Create date : 21/06/2020
 * Link        : https://github.com/yypurdi/koma-msb-core
 * Description : This is the MSB Connector for Authentication & Control Inter Domain in KOMA Network
 *               This module is implemented in MicroSB side for Public/Private Environment
 */

package com.micro.msb.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProcessManager extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessManager.class);

    @Value("${server.queue.name}")
    private String name;
    @Value("${server.queue.dealer}")
    private String tcpConnectRep;
    @Value("${server.queue.puller}")
    private String tcpConnectPush;
    @Value("${server.queue.splitter.number}")
    private Integer numberOfProcess;
    
    private ProcessThread sessions[];

    @Override
    public void run() {

        LOG.info("Initiate Micro Service("+name+")...");
        sessions = new ProcessThread[numberOfProcess];

        for (ProcessThread session : sessions) {
            session = new ProcessThread();
            session.setTcpConnectRep(tcpConnectRep);
            session.setTcpConnectPush(tcpConnectPush);
            session.start();
        }
    }
}
