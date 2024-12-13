package com.org.salonBooking.api.service.dto;

import com.org.salonBooking.api.promotion.entity.Promotion;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for Service.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    private Long id;

    private String name;

    private String categoryName;

    private String description;

    private Double price;

    private Integer duration; // Duration in minutes

    private boolean hasActivePromotion;

    private Set<Promotion> promotions;
}
