package se.koarito.JavaEEProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.projection.UserView;
import se.koarito.JavaEEProject.data.requestbody.UserRequest;
import se.koarito.JavaEEProject.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    private long createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping("/getUser")
    private ResponseEntity<UserView> getUser(@RequestParam("email") String getEmail) {
        return userService.getUser(getEmail);
    }

    @PostMapping("/saveUser")
    private ResponseEntity<User> getUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("deleteUser")
    private void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

    @PatchMapping("/editUser/{email}")
    private ResponseEntity<User> editUser(@RequestBody User user, @PathVariable("email")String email){
        return userService.editUser(user,email);
    }
}
