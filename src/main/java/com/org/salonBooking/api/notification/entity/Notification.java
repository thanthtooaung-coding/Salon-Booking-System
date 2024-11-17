package com.org.salonBooking.api.notification.entity;

import java.time.LocalDateTime;

import com.org.salonBooking.api.notification.enums.Status;
import com.org.salonBooking.api.notification.enums.Type;
import com.org.salonBooking.api.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a notification entity.
 */
@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    @Column(nullable = false)
    private Long createdAt = System.currentTimeMillis();
}
