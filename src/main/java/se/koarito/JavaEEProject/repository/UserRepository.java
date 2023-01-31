package se.koarito.JavaEEProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.projection.UserView;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserView> findByEmail(String email);
    User findByFirstName(String firstName);

}
