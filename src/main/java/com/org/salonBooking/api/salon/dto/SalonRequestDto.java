package com.org.salonBooking.api.salon.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object to create and update Salon.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalonRequestDto {

    @NotBlank(message = "Name is required")
    @Size(max = 45, message = "Name cannot exceed 45 characters")
    private String name;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String address;
}
