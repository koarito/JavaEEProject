package se.koarito.JavaEEProject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import se.koarito.JavaEEProject.service.UserService;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final UserService userService;
    private final PasswordConfig bCrypt;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/", "/error", "/login",
                  "/api/**", "/rest/**", "/token/**")
                //   , "localhost:8080/api/editDay/15", "/static/**")
                .permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .authenticationProvider(authenticationOverride());    //Tell Spring Security to use our implementation

        http.cors().configurationSource(request -> {
            CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
            corsConfiguration.addAllowedMethod("DELETE");
            corsConfiguration.addAllowedMethod("POST");
            corsConfiguration.addAllowedMethod("GET");
            corsConfiguration.addAllowedMethod("PATCH");
            return corsConfiguration;

        });

        http.sessionManagement(
                session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS)
        );

        http.httpBasic();

        http.csrf().disable();

        http.headers().frameOptions().sameOrigin();

        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);


        return http.build();
    }


    public DaoAuthenticationProvider authenticationOverride() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(bCrypt.bCryptPasswordEncoder());

        return provider;
    }
}

