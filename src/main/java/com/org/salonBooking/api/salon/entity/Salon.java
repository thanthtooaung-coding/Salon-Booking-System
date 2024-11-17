package com.org.salonBooking.api.salon.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a salon entity.
 */
@Getter
@Setter
@Entity
@Table(name = "salon")
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long createdAt = System.currentTimeMillis();
}
