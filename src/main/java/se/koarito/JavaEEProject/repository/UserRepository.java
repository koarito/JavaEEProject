package se.koarito.JavaEEProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.projection.UserView;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserView> findByEmail(String email);
}
