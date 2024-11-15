package com.org.salonBooking.api.user.repository;

import com.org.salonBooking.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findById(@NonNull Long id);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
