package com.org.salonBooking.api.salon.service.impl;

import com.org.salonBooking.api.salon.dto.SalonDto;
import com.org.salonBooking.api.salon.dto.SalonRequestDto;
import com.org.salonBooking.api.salon.entity.Salon;
import com.org.salonBooking.api.salon.repository.SalonRepository;
import com.org.salonBooking.api.salon.service.SalonService;
import com.org.salonBooking.common.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SalonServiceImplement extends BaseServiceImpl<Salon, Long> implements SalonService {

    private final ModelMapper modelMapper;
    private final SalonRepository salonRepository;

    @Override
    protected JpaRepository<Salon, Long> getRepository() { return salonRepository; }

    @Override
    protected String getEntityName() { return "Salon"; }

    @Override
    public SalonDto getSalonById(Long id) {
        Salon salon = findById(id);
        return modelMapper.map(salon, SalonDto.class);
    }

    @Override
    public Page<SalonDto> getAllSalons(Pageable pageable) {
        return findAll(pageable).map((salon) -> modelMapper.map(salon, SalonDto.class));
    }

    @Override
    public SalonDto createSalon(SalonRequestDto salonDto) {

        if(salonRepository.existsByName(salonDto.getName())) {
            throw new DataIntegrityViolationException("Salon name already exists");
        }

        Salon salon = modelMapper.map(salonDto, Salon.class);
        Salon savedSalon = create(salon);
        return modelMapper.map(savedSalon, SalonDto.class);
    }

    @Override
    public SalonDto updateSalon(Long id, SalonRequestDto salonDto) {
        Salon salon = findById(id);
        String salonNameFromDto = salonDto.getName();

        if (salon.getName().equals(salonNameFromDto) && salonRepository.existsByName(salonNameFromDto)) {
            throw new DataIntegrityViolationException("Salon name already exists");
        }

        Optional.ofNullable(salonDto.getName())
                .filter(name -> !name.isEmpty())
                .ifPresent(salon::setName);

        Optional.ofNullable(salonDto.getAddress())
                .filter(address -> !address.isEmpty())
                .ifPresent(salon::setAddress);

        Salon updatedSalon = update(id, salon);
        return modelMapper.map(updatedSalon, SalonDto.class);
    }

    @Override
    public void deleteSalon(Long id) { delete(id); }
}
