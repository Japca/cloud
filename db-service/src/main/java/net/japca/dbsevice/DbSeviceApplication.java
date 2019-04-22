package net.japca.dbsevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class DbSeviceApplication {

    public static void main(String[] args) throws UnknownHostException {
        String property = System.getProperty("server.name");
        if (property == null || property.isBlank()) {
            System.setProperty("server.name", InetAddress.getLocalHost().getHostName());
        }

        SpringApplication.run(DbSeviceApplication.class, args);
    }

}
