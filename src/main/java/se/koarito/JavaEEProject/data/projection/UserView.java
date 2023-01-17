package se.koarito.JavaEEProject.data.projection;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import se.koarito.JavaEEProject.data.enm.Role;

public interface UserView {
    long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    Role getRole();
}
