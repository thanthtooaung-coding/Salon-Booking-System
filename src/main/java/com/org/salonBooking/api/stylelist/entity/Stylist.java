package com.org.salonBooking.api.stylelist.entity;

import com.org.salonBooking.api.salon.entity.Salon;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a styleList entity.
 */
@Getter
@Setter
@Entity
@Table(name = "stylelist")
public class Stylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialty;

    @Column(length = 50)
    private String experienceLevel;

    @Column(columnDefinition = "TEXT")
    private String availability;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    private Salon salon;
}
