package net.japca.dbsevice;

import com.ecwid.consul.v1.ConsistencyMode;
import com.ecwid.consul.v1.QueryParams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class DbServiceApplication {

    public static void changeConsistencyModeToStale() {
        for (Field field : QueryParams.class.getFields()) {
            if ("DEFAULT".equals(field.getName())) {
                try {
                    field.setAccessible(true);
                    Field modifiersField = Field.class.getDeclaredField("modifiers");
                    modifiersField.setAccessible(true);
                    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                    field.set(null, new QueryParams(ConsistencyMode.STALE));
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    log.error("Error while try to set stale mode to consul", e);
                }

                log.info("Consistence mode has been set to stale successfully");
            }
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        String property = System.getProperty("server.name");
        if (property == null || property.isBlank()) {
            System.setProperty("server.name", InetAddress.getLocalHost().getHostName());
        }

        changeConsistencyModeToStale();

        SpringApplication.run(DbServiceApplication.class, args);
    }

}
