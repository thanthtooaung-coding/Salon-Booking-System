package com.org.salonBooking.api.appointment.entity;

import com.org.salonBooking.api.appointment.enums.Status;
import com.org.salonBooking.api.booking.entity.Booking;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Represents an appointment entity.
 */
@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;
}
