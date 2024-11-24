package com.org.salonBooking.api.stylelist.service;

import com.org.salonBooking.api.salon.entity.Salon;
import com.org.salonBooking.api.salon.service.SalonService;
import com.org.salonBooking.api.stylelist.dto.StylistCreateDto;
import com.org.salonBooking.api.stylelist.dto.StylistDto;
import com.org.salonBooking.api.stylelist.dto.StylistUpdateDto;
import com.org.salonBooking.api.stylelist.entity.Stylist;
import com.org.salonBooking.api.stylelist.repository.StylistRepository;
import com.org.salonBooking.common.exception.ResourceNotFoundException;
import com.org.salonBooking.common.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StylistServiceImplement extends BaseServiceImpl<Stylist, Long> implements StylistService {

    private final StylistRepository stylistRepository;
    private final ModelMapper modelMapper;
    private final SalonService salonService;

    @Override
    protected JpaRepository<Stylist, Long> getRepository() { return stylistRepository; }

    @Override
    protected String getEntityName() { return "Stylist"; }

    @Override
    public StylistDto getStylistById(Long id) {
        Stylist stylist = findById(id);
        return modelMapper.map(stylist, StylistDto.class);
    }

    @Override
    public Page<StylistDto> getAllStylists(Pageable pageable) {
        return findAll(pageable).map(stylist -> modelMapper.map(stylist, StylistDto.class));
    }

    @Override
    public StylistDto createStylist(StylistCreateDto stylistDto) {
        Stylist stylist = modelMapper.map(stylistDto, Stylist.class);
        Stylist savedStylist = create(stylist);
        return modelMapper.map(savedStylist, StylistDto.class);
    }

    @Override
    public StylistDto updateStylist(Long id, StylistUpdateDto stylistDto) {
        Stylist stylist = findById(id);

        Optional.ofNullable(stylistDto.getName())
                .filter(name -> !name.isEmpty())
                .ifPresent(stylist::setName);

        Optional.ofNullable(stylistDto.getSpecialty())
                .filter(specialty -> !specialty.isEmpty())
                .ifPresent(stylist::setSpecialty);

        Optional.ofNullable(stylistDto.getExperienceLevel())
                .filter(experienceLevel -> !experienceLevel.isEmpty())
                .ifPresent(stylist::setExperienceLevel);

        Optional.ofNullable(stylistDto.getAvailability())
                .filter(availability -> !availability.isEmpty())
                .ifPresent(stylist::setAvailability);

        Optional.ofNullable(stylistDto.getPrice())
                .filter(price -> !price.isNaN() && price > 0.0)
                .ifPresent(stylist::setPrice);

        Stylist updatedStylist = update(id, stylist);
        return modelMapper.map(updatedStylist, StylistDto.class);
    }

    @Override
    public void deleteStylist(Long id) { delete(id); }

    @Override
    public StylistDto changeSalon(Long id, Long newSalonId) {

        Stylist stylist = findById(id);

        if (stylist == null) {
            throw new ResourceNotFoundException(getEntityName() ,"id", id);
        }

        stylist.setSalon(salonService.findById(newSalonId));

        Stylist updatedStylist = update(id, stylist);

        return modelMapper.map(updatedStylist, StylistDto.class);
    }

}
