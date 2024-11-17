package com.org.salonBooking.api.auditLog.entity;

import com.org.salonBooking.api.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Represents an audit_log entity.
 */
@Getter
@Setter
@Entity
@Table(name = "audit_log")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 255)
    private String action;

    @Column(columnDefinition = "TEXT")
    private String details;

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}
