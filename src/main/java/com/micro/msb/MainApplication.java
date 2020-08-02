/*
 * Copyright   : KOMA-Network (Indonesia IoT Club)
 * Create by   : Yan Yan Purdiansah
 * Create date : 21/06/2020
 * Link        : https://github.com/koma-network/koma-msb
 * Description : This is the MSB Connector for Authentication & Control Inter Domain in KOMA Network
 *               This module is implemented in MicroSB side for Public/Private Environment
 */
package com.micro.msb;

import com.micro.msb.core.ProcessManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import java.util.concurrent.Executors;

/**
 *
 * @author Yan Yan Purdiansah
 */
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private ProcessManager balancer;    
    
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {        
        Executors.newFixedThreadPool(1).execute(balancer);
    }
}
