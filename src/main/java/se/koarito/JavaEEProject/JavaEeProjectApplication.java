package se.koarito.JavaEEProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.enm.Role;
import se.koarito.JavaEEProject.repository.UserRepository;

@SpringBootApplication
public class JavaEeProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaEeProjectApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner usersMockup(UserRepository repository) {
		return (args) -> {
			// mockup data
			repository.save(new User("Elena", "Rutsson", "Elena.Rutsson@gmail.com", "fndjsfnsjk", Role.ADMIN));
		};
	}
	*/

}
