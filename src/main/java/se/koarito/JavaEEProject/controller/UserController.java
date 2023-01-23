package se.koarito.JavaEEProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.projection.UserView;
import se.koarito.JavaEEProject.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getUser")
    private UserView getUser(@RequestParam("email") String getEmail) {
        return userService.getUser(getEmail);
    }

    @PutMapping("/saveUser")
    private User getUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("deleteUser")
    private void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

}
