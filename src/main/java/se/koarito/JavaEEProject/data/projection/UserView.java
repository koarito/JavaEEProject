package se.koarito.JavaEEProject.data.projection;

import se.koarito.JavaEEProject.data.enm.Role;

public interface UserView {
    long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    Role getRole();
}
