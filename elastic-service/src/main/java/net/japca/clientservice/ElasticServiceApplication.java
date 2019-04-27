package net.japca.clientservice;

import net.japca.clientservice.model.Item;
import net.japca.clientservice.properties.ElasticProperties;
import net.japca.clientservice.repository.ItemRepository;
import net.japca.common.CommonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(ElasticProperties.class)
public class ElasticServiceApplication {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ElasticProperties properties;

    public static void main(String[] args) throws UnknownHostException {
        CommonUtils.setServiceIdSsServername();
        CommonUtils.changeConsistencyModeToStale();
        SpringApplication.run(ElasticServiceApplication.class, args);
    }

    @PostConstruct
    public void init() {
        repository.save(new Item().setName("Elastic item 1"));
    }


    @Scheduled(fixedRate = 1000)
    public void log() {
        log.info("Test key: {}", properties.getTestKey());
        List<Item> byName = repository.findByName("Elastic item 1");

        log.info("Elastic item: {}", byName.get(0));

    }
}
