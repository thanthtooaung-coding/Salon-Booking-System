package com.org.salonBooking.api.stylelist.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object to create Stylist.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StylistCreateDto {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Specialty is required")
    @Size(max = 100, message = "Specialty cannot exceed 100 characters")
    private String specialty;

    @NotBlank(message = "Experience Level is required")
    @Size(max = 50, message = "Experience Level cannot exceed 50 characters")
    private String experienceLevel;

    @NotBlank(message = "Availability is required")
    private String availability;

    @NotNull(message = "Salon ID is required")
    @Min(value = 1, message = "Salon ID must be a positive value")
    private Long salonId;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private Double price;
}
