package com.org.salonBooking.api.service.entity;

import com.org.salonBooking.api.category.entity.Category;
import com.org.salonBooking.api.promotion.entity.Promotion;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @Column(nullable = false)
    private boolean hasActivePromotion = false;

    @ManyToMany(mappedBy = "services")
    private Set<Promotion> promotions = new HashSet<>();

    public void addPromotion(Promotion promotion) {
        this.promotions.add(promotion);
        this.hasActivePromotion = true;
    }

    public void removePromotion(Promotion promotion) {
        this.promotions.remove(promotion);
        this.hasActivePromotion = !this.promotions.isEmpty();
    }
}
