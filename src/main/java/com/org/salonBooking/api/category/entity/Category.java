package com.org.salonBooking.api.category.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * Represents a category entity.
 */
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;
}
