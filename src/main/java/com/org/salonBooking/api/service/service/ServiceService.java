package com.org.salonBooking.api.service.service;

import com.org.salonBooking.api.service.dto.ServiceDto;
import com.org.salonBooking.api.service.dto.ServiceRequestDto;
import com.org.salonBooking.api.service.entity.Service;
import com.org.salonBooking.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService extends BaseService<Service, Long> {
    ServiceDto getServiceById(Long id);
    Page<ServiceDto> getAllServices(Pageable pageable);
    ServiceDto saveService(ServiceRequestDto serviceDto);
    ServiceDto updateService(Long id, ServiceRequestDto serviceDto);
    void deleteService(Long id);
}
