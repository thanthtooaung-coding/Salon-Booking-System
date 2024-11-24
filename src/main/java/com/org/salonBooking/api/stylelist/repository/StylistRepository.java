package com.org.salonBooking.api.stylelist.repository;

import com.org.salonBooking.api.stylelist.entity.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StylistRepository extends JpaRepository<Stylist, Long> {
}
