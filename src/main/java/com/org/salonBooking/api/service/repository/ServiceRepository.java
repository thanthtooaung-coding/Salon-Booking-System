package com.org.salonBooking.api.service.repository;

import com.org.salonBooking.api.service.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    boolean existsByName(String name);
}
