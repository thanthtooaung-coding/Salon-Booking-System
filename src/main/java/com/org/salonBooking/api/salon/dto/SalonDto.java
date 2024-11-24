package com.org.salonBooking.api.salon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for Salon.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalonDto {

    private String name;

    private String address;
}
