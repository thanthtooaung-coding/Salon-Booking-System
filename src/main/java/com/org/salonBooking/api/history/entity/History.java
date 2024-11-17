package com.org.salonBooking.api.history.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a history entity.
 */
@Getter
@Setter
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String userName;

    @Column(nullable = false, length = 45)
    private String categoryName;

    @Column(nullable = false)
    private LocalDate bookingDate;

    @Column(nullable = false)
    private LocalTime bookingTime;

    @Column(nullable = false, length = 45)
    private String paymentMethod;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal cost;
}
