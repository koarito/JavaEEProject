package se.koarito.JavaEEProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.projection.UserView;
import se.koarito.JavaEEProject.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserView getUser(String getEmail) {
        return userRepository.findByEmail(getEmail).get();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
