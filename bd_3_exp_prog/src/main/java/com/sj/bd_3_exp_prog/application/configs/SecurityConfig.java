package com.sj.bd_3_exp_prog.application.configs;

import com.sj.bd_3_exp_prog.services.AppUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AppUserService appUserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(appUserService).passwordEncoder(passwordEncoder());
        return auth.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            web.ignoring().requestMatchers("/css/**");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> {
                authorize.requestMatchers("/", "/register", "/login", "/users").permitAll();
                authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).hasAuthority("ROLE_ADMIN");
                authorize.anyRequest().authenticated();
            })
            .csrf(csrf -> {
                csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"));
            })
            .headers(headers -> {
                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
            })
            .formLogin(form -> {
                form.loginPage("/login");
                form.loginProcessingUrl("/authenticate");
                form.successHandler((request, response, authentication) -> {
                    HttpSession session = request.getSession();
                    session.setAttribute("authentication", authentication);

                    String successUrl = "/main";
                    response.sendRedirect(successUrl);
                });
                form.failureUrl("/login?error");
                form.usernameParameter("email");
                form.passwordParameter("password");
            })
            .logout(out -> {
                out.logoutUrl("/logout");
                out.logoutSuccessUrl("/login?logout");
                out.invalidateHttpSession(true);
            });
        return http.build();
    }
}
