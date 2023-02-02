package se.koarito.JavaEEProject.data.requestbody;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthRequest {
    private String email;
    private String password;
}
