package ch.so.agi.datahub;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .csrf()
        .and()
        .authorizeRequests(authorize ->
          authorize.mvcMatchers("/").permitAll()
            .anyRequest().authenticated())
        .oauth2Login()
        .and()
        .logout()
        .logoutSuccessUrl("/");
    }
    */
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off  
        http
            .authorizeRequests()
                .mvcMatchers("/ping")
                .permitAll()
                .and()
            .authorizeRequests()
                .mvcMatchers("/")
                .permitAll()
                .and()
            .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
            .oauth2Login();
        //@formatter:on  
    }
}
