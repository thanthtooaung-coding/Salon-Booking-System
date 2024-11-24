package com.org.salonBooking.api.salon.repository;

import com.org.salonBooking.api.salon.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Long> {
    boolean existsByName(String name);
}
