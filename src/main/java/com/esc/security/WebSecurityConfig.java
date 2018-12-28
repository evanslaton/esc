package com.esc.security;

import com.esc.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // Hashes passwords
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    // Tells server/Spring security to use use the userDetailsService and bCryptEncoder
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    // https://www.baeldung.com/spring-security-login
    // Sets up how different requests should be authorized/handled
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .cors().disable()
            .csrf().disable()
            .authorizeRequests()

            // Pages anyone is authorized to go to at any time (including not logged in)
            .antMatchers("/", "/signup").permitAll()
            .antMatchers("/images/**").permitAll()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/js/**").permitAll()
            .anyRequest().authenticated()

            // Login handlers
            .and()
            .formLogin()
            .loginPage("/")
            .loginProcessingUrl("/perform_login")
            .defaultSuccessUrl("/profile", true)
            .failureUrl("/?error=true")

            // Logout handlers
            .and()
            .logout()
            .logoutUrl("/perform_logout")
            .deleteCookies("JSESSIONID");
    }

    // Returns a useful error message if authentication fails
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
