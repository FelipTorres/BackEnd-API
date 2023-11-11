package com.agendamentos.FelipeTorres.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService()
    {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.withUsername("cotemig").password(encoder.encode("cotemig")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer()
    {
        return (web) -> web.ignoring().antMatchers("/**");
    }
}
