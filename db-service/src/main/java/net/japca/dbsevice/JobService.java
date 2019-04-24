package net.japca.dbsevice;

import net.japca.dbsevice.properties.DbServiceProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Jakub krhovják on 4/6/19.
 */

@Slf4j
public class JobService {


    @Value("${jobKey}")
    private String jobKey;
    @Autowired
    private DbServiceProperties properties;

    @Scheduled(fixedRate = 1000)
    public void run() {
        log.info("job started with value: {}", properties.getJobKey());
    }
}
