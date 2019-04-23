package net.japca.admin.config;

import de.codecentric.boot.admin.server.config.AdminServerNotifierAutoConfiguration;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.web.client.HttpHeadersProvider;

import net.japca.admin.AuthHttpHeadersProvider;
import net.japca.admin.CustomSlackNotifier;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jakub krhovják on 4/23/19.
 */
@Configuration
public class AdminConfiguration {

    @Bean
    public HttpHeadersProvider adminHeaderProvider() {
        return new AuthHttpHeadersProvider();
    }


    @AutoConfigureBefore({AdminServerNotifierAutoConfiguration.NotifierTriggerConfiguration.class, AdminServerNotifierAutoConfiguration.CompositeNotifierConfiguration.class})
    public static class SlackNotifierConfiguration {

        @Bean
        @ConfigurationProperties("spring.boot.admin.notify.slack")
        public CustomSlackNotifier customSlackNotifier(InstanceRepository repository) {
            return new CustomSlackNotifier(repository);
        }
    }

}
