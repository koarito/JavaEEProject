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

    @GetMapping("/getuser")
    ResponseEntity<UserView> getUser(@RequestParam("email") String email) {
        return userService.getUser(email);
    }
    @DeleteMapping("/deleteuser")
    private void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

    //TODO not working
    @PatchMapping("/edituser/{id}")
    private ResponseEntity<User> editUser(@RequestBody User user, @PathVariable("id") Long id){
        return userService.editUser(user,id);
    }
}
