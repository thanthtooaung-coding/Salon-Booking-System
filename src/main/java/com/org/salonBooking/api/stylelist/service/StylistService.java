package com.org.salonBooking.api.stylelist.service;

import com.org.salonBooking.api.stylelist.dto.StylistCreateDto;
import com.org.salonBooking.api.stylelist.dto.StylistDto;
import com.org.salonBooking.api.stylelist.dto.StylistUpdateDto;
import com.org.salonBooking.api.stylelist.entity.Stylist;
import com.org.salonBooking.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StylistService extends BaseService<Stylist, Long> {
    StylistDto getStylistById(Long id);
    Page<StylistDto> getAllStylists(Pageable pageable);
    StylistDto createStylist(StylistCreateDto stylistDto);
    StylistDto updateStylist(Long id, StylistUpdateDto stylistDto);
    void deleteStylist(Long id);
    StylistDto changeSalon(Long id, Long newSalonId);
}
