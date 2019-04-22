package net.japca.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) throws UnknownHostException {
        String property = System.getProperty("server.name");
        if (property == null || property.isBlank()) {
            System.setProperty("server.name", InetAddress.getLocalHost().getHostName());
        }
        SpringApplication.run(AdminApplication.class, args);
    }

}
