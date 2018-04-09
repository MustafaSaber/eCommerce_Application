package com.ecommerce.sw2.Confi;

import com.ecommerce.sw2.Models.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private  Failure authenticationFaliureHandler;

    @Qualifier("loggedUserDetailsSerivce")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class);
        http.cors();
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/getusers", "/create").permitAll()
                //.antMatchers("/css/**", "/images/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .formLogin()
                //.loginPage("/login")
                //.failureForwardUrl("/login?error")
                // .loginProcessingUrl("/login")
                .permitAll()
                .usernameParameter("username")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFaliureHandler)
                .and()
                .logout()
                .permitAll();
                //.and()
                //.httpBasic()

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication();
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler() {
        return new MySavedRequestAwareAuthenticationSuccessHandler();
    }

    @Bean
    public Failure myFailureHandler() {
        return new Failure();
    }
}
