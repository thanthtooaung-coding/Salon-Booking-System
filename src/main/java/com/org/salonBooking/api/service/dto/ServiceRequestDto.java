package com.org.salonBooking.api.service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object to create and update Service.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequestDto {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 1, message = "Description must have at least 1 character")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "Duration is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Duration must be greater than 0")
    private Integer duration;
}
