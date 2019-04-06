package net.japca.dbsevice.config;

import net.japca.dbsevice.JobService;
import net.japca.dbsevice.properties.DbServiceProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jakub krhovják on 4/6/19.
 */
@Configuration
@EnableConfigurationProperties(DbServiceProperties.class)
public class DbServiceConfiguration {

    @Bean
    public JobService jobService() {
        return new JobService();
    }
}
