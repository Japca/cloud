package net.japca.dbsevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@EnableWebFlux
@EnableDiscoveryClient
@SpringBootApplication
public class DbSeviceApplication {

    public static void main(String[] args) throws UnknownHostException {
//        System.setProperty("server.name", InetAddress.getLocalHost().getHostName());
        SpringApplication.run(DbSeviceApplication.class, args);
    }

}
