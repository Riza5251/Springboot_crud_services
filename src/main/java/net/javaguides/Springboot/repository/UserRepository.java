package net.javaguides.Springboot.repository;

import net.javaguides.Springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    //writing the function which will extract user by email
    Optional<User> findByEmail(String email);
}
