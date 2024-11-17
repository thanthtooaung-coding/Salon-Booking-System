package com.org.salonBooking.api.booking.entity;

import com.org.salonBooking.api.salon.entity.Salon;
import com.org.salonBooking.api.service.entity.Service;
import com.org.salonBooking.api.stylelist.entity.Stylist;
import com.org.salonBooking.api.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a booking entity.
 */
@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    private Salon salon;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "stylist_id")
    private Stylist stylist;

    @Column(nullable = false)
    private Long createdAt = System.currentTimeMillis();

    @Column(nullable = false)
    private Long updatedAt = System.currentTimeMillis();
}
