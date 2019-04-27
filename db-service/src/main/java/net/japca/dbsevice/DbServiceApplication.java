package net.japca.dbsevice;

import net.japca.common.CommonUtils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class DbServiceApplication {

    public static void main(String[] args) throws UnknownHostException {
        CommonUtils.setServiceIdSsServername();
        CommonUtils.changeConsistencyModeToStale();

        SpringApplication.run(DbServiceApplication.class, args);
    }

}
