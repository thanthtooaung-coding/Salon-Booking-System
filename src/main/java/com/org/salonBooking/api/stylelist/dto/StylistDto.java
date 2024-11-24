package com.org.salonBooking.api.stylelist.dto;

import com.org.salonBooking.api.salon.dto.SalonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for Stylist.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StylistDto {

    private String name;

    private String specialty;

    private String experienceLevel;

    private String availability;

    private SalonDto salon;

    private Double price;
}
