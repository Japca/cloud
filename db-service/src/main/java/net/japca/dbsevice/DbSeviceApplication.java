package net.japca.dbsevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableScheduling
@EnableWebFlux
@EnableDiscoveryClient
@SpringBootApplication
public class DbSeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbSeviceApplication.class, args);
    }

}
