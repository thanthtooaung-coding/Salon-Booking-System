package com.org.salonBooking.api.salon.service;

import com.org.salonBooking.api.salon.dto.SalonDto;
import com.org.salonBooking.api.salon.dto.SalonRequestDto;
import com.org.salonBooking.api.salon.entity.Salon;
import com.org.salonBooking.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalonService extends BaseService<Salon, Long> {
    SalonDto getSalonById(Long id);
    Page<SalonDto> getAllSalons(Pageable pageable);
    SalonDto createSalon(SalonRequestDto salonDto);
    SalonDto updateSalon(Long id, SalonRequestDto salonDto);
    void deleteSalon(Long id);
}
