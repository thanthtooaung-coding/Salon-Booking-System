package com.org.salonBooking.api.service.entity;

import com.org.salonBooking.api.category.entity.Category;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a service entity.
 */
@Getter
@Setter
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer duration; // Duration in minutes
}
