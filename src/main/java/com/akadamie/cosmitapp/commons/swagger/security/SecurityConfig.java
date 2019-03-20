package com.akadamie.cosmitapp.commons.swagger.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private CustomUserService customUserService;
    private PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomUserService customUserService, PasswordEncoder passwordEncoder) {
        this.customUserService = customUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests() // właczam autoryzacje
                .antMatchers("/login**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                // config form in login page
                .loginProcessingUrl("/signin") // form action link
                .usernameParameter("username") //input name
                .passwordParameter("password") // input password
                .successHandler(
                        (req, res, auth) -> {
                            for (GrantedAuthority g : auth.getAuthorities()
                            ) {
                                System.out.println(g.getAuthority());

                            }
                            res.sendRedirect("/");
                        })
                .failureHandler(
                        (req, res, exp) -> {
                            String errorMessage;
                            if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {
                                errorMessage = "Invalid username or password";

                            } else {
                                errorMessage = "unknown error " + exp.getMessage();
                            }
                            req.getSession().setAttribute("message", errorMessage);
                            res.sendRedirect("/login");
                        }
                )
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(
                        (req, res, auth) -> {
                            res.sendRedirect("/");
                        }
                )
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login"); // error: 403 handler
        http
                .csrf().disable();// odpornosc na ataki ddos
        http
                .headers().frameOptions().disable(); // for H2 memory database

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService)
                .passwordEncoder(passwordEncoder);
    }
}
