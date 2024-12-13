package com.org.salonBooking.api.service.service.impl;

import com.org.salonBooking.api.service.dto.ServiceDto;
import com.org.salonBooking.api.service.dto.ServiceRequestDto;
import com.org.salonBooking.api.service.entity.Service;
import com.org.salonBooking.api.service.repository.ServiceRepository;
import com.org.salonBooking.api.service.service.ServiceService;
import com.org.salonBooking.common.service.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl extends BaseServiceImpl<Service, Long> implements ServiceService {

    private final ModelMapper modelMapper;
    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ModelMapper modelMapper, ServiceRepository serviceRepository) {
        this.modelMapper = modelMapper;
        this.serviceRepository = serviceRepository;
    }

    @Override
    protected JpaRepository<Service, Long> getRepository() { return serviceRepository; }

    @Override
    protected String getEntityName() { return "Service"; }

    @Override
    public ServiceDto getServiceById(Long id) {
        Service service = findById(id);
        return modelMapper.map(service, ServiceDto.class);
    }

    @Override
    public Page<ServiceDto> getAllServices(Pageable pageable) {
        return findAll(pageable).map((service) -> modelMapper.map(service, ServiceDto.class));
    }

    @Override
    public ServiceDto saveService(ServiceRequestDto serviceDto) {
        Service service = modelMapper.map(serviceDto, Service.class);
        Service savedService = create(service);
        return modelMapper.map(savedService, ServiceDto.class);
    }

    @Override
    public ServiceDto updateService(Long id, ServiceRequestDto serviceDto) {
        Service service = findById(id);

        Optional.ofNullable(serviceDto.getName())
                .filter(name -> !name.isEmpty())
                .ifPresent(service::setName);

        Optional.ofNullable(serviceDto.getDescription())
                .filter(description -> !description.isEmpty())
                .ifPresent(service::setDescription);

        Service updatedService = update(id, service);
        return modelMapper.map(updatedService, ServiceDto.class);
    }

    @Override
    public void deleteService(Long id) { delete(id); }
}
