package net.japca.clientservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * Created by Jakub krhovják on 4/26/19.
 */

@Data
@ConfigurationProperties
public class ElasticProperties {

    private String testKey;

}
