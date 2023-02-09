package se.koarito.JavaEEProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    ResponseEntity<User> getUser(@RequestParam("email") String email) {
        return userService.getUser(email);
    }


    @DeleteMapping("/deleteuser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

    @PatchMapping("/edituser/{email}")
    private ResponseEntity<User> editUser(@RequestBody User user, @PathVariable("email") String email){
        return userService.editUser(user,email);
    }
}
