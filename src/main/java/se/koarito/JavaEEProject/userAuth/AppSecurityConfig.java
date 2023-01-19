package se.koarito.JavaEEProject.userAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;

@Configuration
@EnableWebFluxSecurity
public class AppSecurityConfig {



    @Bean
    SecurityWebFilterChain apiHttpSecurity(ServerHttpSecurity http) {
        http
                .securityMatcher(new PathPatternParserServerWebExchangeMatcher("/api/**"))
                .authorizeExchange((exchanges) -> exchanges
                        .anyExchange().authenticated()
                );

        return http.build();
    }

    @Bean
    SecurityWebFilterChain webHttpSecurity(ServerHttpSecurity http) {
        http
                .authorizeExchange((exchanges) -> exchanges
                        .anyExchange().authenticated()
                )
                .httpBasic();
        return http.build();
    }



/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests ()
                    .requestMatchers ("/", "/error", "/login", "/api/getUsers").permitAll()
                    .requestMatchers ("/adminPage" ).hasRole("ADMIN")
                    .anyRequest().authenticated ()
                    .and()
                    .formLogin();
            return http.build();

    }


 */

}


