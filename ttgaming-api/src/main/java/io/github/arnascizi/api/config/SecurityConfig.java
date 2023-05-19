package io.github.arnascizi.api.config;

import io.github.arnascizi.api.helper.AuthTokenFilter;
import io.github.arnascizi.bl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
// @EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] PERMIT_URLS = { "/api/**" };

    private final UserService userService;
    private final AuthEntryPointJwt unauthorizedHandler;

    // @Bean
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.cors().and().csrf().disable()
    //             .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
    //             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
    //             .authorizeRequests().antMatchers("/api/users/**").permitAll()
    //             // .antMatchers("/api/test/**").permitAll()
    //             .anyRequest().authenticated();
    //
    //     http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    //
    //     // http.csrf().disable();
    //     // http.headers().frameOptions().disable();
    //     // http.authorizeRequests()
    //     //         .antMatchers("/api/**").permitAll();
    //
    //     // http.authorizeRequests().antMatchers(PERMIT_URLS).denyAll();
    //     // http.authorizeRequests().anyRequest().hasAnyRole("USER");
    //     //
    //     // FormLoginConfigurer<HttpSecurity> formLogin = http.formLogin();
    //     // formLogin.loginPage("/login");
    //     // formLogin.usernameParameter("email");
    //     // formLogin.passwordParameter("password");
    //     // formLogin.defaultSuccessUrl("/");
    //     //
    //     // http.exceptionHandling().accessDeniedPage("/access_denied");
    //     //
    //     // http.headers().frameOptions().disable();
    //     //
    //     // http.csrf().disable();
    // }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(encoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/**").permitAll()
//                .antMatchers("/api/games/**").anonymous()
                .anyRequest().authenticated();

        http.authenticationProvider(authProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}