package se.koarito.JavaEEProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){

        return new BCryptPasswordEncoder(14); //Strength: 4-30 //standard 10
    }
}
