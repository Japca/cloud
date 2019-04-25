package net.japca.dbsevice.config;

import com.ecwid.consul.v1.ConsistencyMode;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.cloud.consul.discovery.ConsulCatalogWatch;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.context.ApplicationEventPublisher;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Jakub krhovják on 4/25/19.
 */

@Slf4j
public class StaleConsulCatalogWatch extends ConsulCatalogWatch {

    private final AtomicReference<BigInteger> catalogServicesIndex = new AtomicReference<>();

    @Autowired
    private ConsulDiscoveryProperties properties;

    @Autowired
    private ConsulClient consul;

    private ApplicationEventPublisher publisher;

    public StaleConsulCatalogWatch(ConsulDiscoveryProperties properties, ConsulClient consul) {
        super(properties, consul);
    }

    @Override
    public void catalogServicesWatch() {
        try {
            long index = -1;
            if (this.catalogServicesIndex.get() != null) {
                index = this.catalogServicesIndex.get().longValue();
            }

            Response<Map<String, List<String>>> response = this.consul.getCatalogServices(
                    new QueryParams(ConsistencyMode.STALE),
                    this.properties.getAclToken());
            Long consulIndex = response.getConsulIndex();
            if (consulIndex != null) {
                this.catalogServicesIndex.set(BigInteger.valueOf(consulIndex));
            }

            if (log.isTraceEnabled()) {
                log.trace("Received services update from consul: " + response.getValue()
                        + ", index: " + consulIndex);
            }
            this.publisher.publishEvent(new HeartbeatEvent(this, consulIndex));
        }
        catch (Exception e) {
            log.error("Error watching Consul CatalogServices", e);
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
