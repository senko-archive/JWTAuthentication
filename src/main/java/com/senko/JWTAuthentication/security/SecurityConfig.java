package com.senko.JWTAuthentication.security;

import com.senko.JWTAuthentication.fliters.JwtAuthenticationFilter;
import com.senko.JWTAuthentication.fliters.LoginFilter;
import com.senko.JWTAuthentication.util.UserPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordCheckUserDetailService passwordCheckUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(passwordCheckUserDetailService)
                .passwordEncoder(UserPasswordEncoder.getUserPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.POST,  "/auth/login/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();

        //LoginFilter loginFilter = new LoginFilter(authenticationManagerBean());
        //loginFilter.setFilterProcessesUrl("/auth/login");

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();

        //http.addFilter(loginFilter);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
