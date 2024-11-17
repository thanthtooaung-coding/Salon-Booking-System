package com.org.salonBooking.api.user.entity;

import com.org.salonBooking.api.user.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a user entity.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(unique = true, nullable = false, length = 230)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean isPremium = false;

    @Column(name = "created_at", updatable = false)
    private Long createdAt = System.currentTimeMillis();

    @Column(name = "is_deleted", nullable = false)
    private Boolean deleted = false;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
