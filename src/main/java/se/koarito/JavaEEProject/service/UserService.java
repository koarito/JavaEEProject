package se.koarito.JavaEEProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.enm.Role;
import se.koarito.JavaEEProject.data.projection.UserView;
import se.koarito.JavaEEProject.data.requestbody.UserRequest;
import se.koarito.JavaEEProject.repository.UserRepository;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public long createUser(UserRequest requestBody){
        User user = User.builder().
                firstName(requestBody.getFirstName())
                .lastName(requestBody.getLastName())
                .email(requestBody.getEmail())
                .password(requestBody.getPassword())
                .role(Role.valueOf(requestBody.getRole())).build();
        return userRepository.save(user).getId();
    }

    public ResponseEntity<UserView> getUser(String email) {
        try {
           UserView user = userRepository.findByEmail(email).get();
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

        User userInDB = (User) userRepository.findByEmail(email).get();
        if (Objects.nonNull(user.getEmail()))
            userInDB.setEmail(user.getEmail());

        if (Objects.nonNull(user.getFirstName()))
            userInDB.setFirstName(user.getFirstName());

        if (Objects.nonNull(user.getLastName()))
            userInDB.setLastName(user.getLastName());

        //TODO: maybe user should not be able to change password...?
        if (Objects.nonNull(user.getPassword()))
            userInDB.setPassword(user.getPassword());

        return new ResponseEntity<>(userRepository.save(userInDB), HttpStatus.OK);
    }

}
