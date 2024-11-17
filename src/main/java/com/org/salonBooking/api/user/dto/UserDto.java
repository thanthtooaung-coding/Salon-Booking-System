package com.org.salonBooking.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for User.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;

    private String email;

    private Long createdAt;

    private String role;

    private Boolean isPremium;

}
