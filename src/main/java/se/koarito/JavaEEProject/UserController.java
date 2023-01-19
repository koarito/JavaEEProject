package se.koarito.JavaEEProject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/api/getUsers")
    private List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
