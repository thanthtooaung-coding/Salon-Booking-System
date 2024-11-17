package com.org.salonBooking.api.payment.entity;

import com.org.salonBooking.api.booking.entity.Booking;
import com.org.salonBooking.api.payment.enums.PaymentMethod;
import com.org.salonBooking.api.payment.enums.Status;
import com.org.salonBooking.api.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a payment entity.
 */
@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private Long paymentDate = System.currentTimeMillis();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.SUCCESSFUL;
}
