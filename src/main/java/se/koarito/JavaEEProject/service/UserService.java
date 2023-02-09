package se.koarito.JavaEEProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.koarito.JavaEEProject.config.PasswordConfig;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.enm.Role;
import se.koarito.JavaEEProject.data.projection.UserView;
import se.koarito.JavaEEProject.data.requestbody.UserRequest;
import se.koarito.JavaEEProject.repository.UserRepository;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    //TODO: change back to userview?
    public ResponseEntity<User> getUser(String email) {
        try {
           User user = userRepository.findByEmail(email).get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception e){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public ResponseEntity<User> editUser(User user, String email){

        User userInDB = userRepository.findByEmail(email).get();
        if (Objects.nonNull(user.getFirstName()))
            userInDB.setFirstName(user.getFirstName());

        if (Objects.nonNull(user.getLastName()))
            userInDB.setLastName(user.getLastName());

        return new ResponseEntity<>(userRepository.save(userInDB), HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}
