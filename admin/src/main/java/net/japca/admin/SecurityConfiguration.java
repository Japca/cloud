package net.japca.admin;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Jakub krhovják on 4/22/19.
 */

@Configuration
public class SecurityConfiguration { //extends WebSecurityConfigurerAdapter {

    private String adminContextPath = "";

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("admin").password("admin").roles("admin");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//            SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//            successHandler.setTargetUrlParameter("redirectTo");
//            successHandler.setDefaultTargetUrl(adminContextPath + "/");
//
//            http.authorizeRequests()
//                .antMatchers(adminContextPath + "/assets/**").permitAll()
//                .antMatchers(adminContextPath + "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
//            .logout().logoutUrl(adminContextPath + "/logout").and()
//            .httpBasic().and()
//            .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .ignoringAntMatchers(adminContextPath + "/instances", adminContextPath + "/actuator/**");
//            // @formatter:on
//    }
}


