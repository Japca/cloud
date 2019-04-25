package net.japca.dbsevice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * Created by Jakub krhovják on 4/6/19.
 */
@Data
@ConfigurationProperties
public class DbServiceProperties {

    private String jobKey;
}
