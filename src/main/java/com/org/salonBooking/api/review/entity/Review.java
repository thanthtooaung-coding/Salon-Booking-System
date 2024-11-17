package com.org.salonBooking.api.review.entity;

import com.org.salonBooking.api.salon.entity.Salon;
import com.org.salonBooking.api.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a review entity.
 */
@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    private Salon salon;

    @Column(nullable = false)
    private Integer rating; // Value between 1 and 5

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false)
    private Long createdAt = System.currentTimeMillis();
}
