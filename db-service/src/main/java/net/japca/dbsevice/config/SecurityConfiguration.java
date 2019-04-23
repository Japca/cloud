package net.japca.dbsevice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * Created by Jakub krhovják on 4/22/19.
 */

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private String adminContextPath = "";

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        http.authorizeRequests()
                .antMatchers(adminContextPath + "/actuator/health").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().and()
                .csrf().disable();
    }
}


