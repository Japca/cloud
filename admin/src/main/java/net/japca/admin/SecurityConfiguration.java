package net.japca.admin;

import de.codecentric.boot.admin.server.web.client.HttpHeadersProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Created by Jakub krhovják on 4/22/19.
 */

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private String adminContextPath = "";

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeRequests()
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/actuator/health").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
                .logout().logoutUrl(adminContextPath + "/logout").and()
                .httpBasic().and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers(adminContextPath + "/instances", adminContextPath + "/actuator/**");

    }

    @Bean
    public HttpHeadersProvider adminHeaderProvider() {
        return new AuthHttpHeadersProvider();
    }

//
//    @AutoConfigureBefore({AdminServerNotifierAutoConfiguration.NotifierTriggerConfiguration.class, AdminServerNotifierAutoConfiguration.CompositeNotifierConfiguration.class})
//    public static class SlackNotifierConfiguration {
//
//        @Bean
//        @ConfigurationProperties("spring.boot.admin.notify.slack")
//        public CustomSlackNotifier customSlackNotifier(InstanceRepository repository) {
//            return new CustomSlackNotifier(repository);
//        }
//    }
}


