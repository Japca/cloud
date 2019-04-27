package net.japca.clientservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by Jakub krhovják on 4/26/19.
 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "ne.japca.clientservice.repository")
public class ElasticServiceConfiguration {

}
