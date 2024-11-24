package com.org.salonBooking.api.salon.controller;

import com.org.salonBooking.api.salon.dto.SalonDto;
import com.org.salonBooking.api.salon.dto.SalonRequestDto;
import com.org.salonBooking.api.salon.service.SalonService;
import com.org.salonBooking.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/salons")
@RequiredArgsConstructor
@Tag(name = "Salon", description = "Operations related to salons")
public class SalonController {

    private final SalonService salonService;

    @Operation(summary = "Get salon by ID", description = "Retrieve a salon by its ID", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Salon retrieved successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SalonDto.class)))
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SalonDto>> getSalonById(@PathVariable Long id) {
        SalonDto salon = salonService.getSalonById(id);
        ApiResponse<SalonDto> response = ApiResponse.<SalonDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Salon retrieved successfully")
                .data(salon)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all salons", description = "Retrieve a list of salons with pagination", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Salons retrieved successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SalonDto.class)))
    @GetMapping
    public ResponseEntity<ApiResponse<Page<SalonDto>>> getAllSalons(Pageable pageable) {
        Page<SalonDto> salons = salonService.getAllSalons(pageable);
        ApiResponse<Page<SalonDto>> response = ApiResponse.<Page<SalonDto>>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Salons retrieved successfully")
                .data(salons)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new salon", description = "Create a new salon by providing salon details", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Salon created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SalonDto.class)))
    @PostMapping
    public ResponseEntity<ApiResponse<SalonDto>> createSalon(@Valid @RequestBody SalonRequestDto salonRequestDto) {
        SalonDto salon = salonService.createSalon(salonRequestDto);
        ApiResponse<SalonDto> response = ApiResponse.<SalonDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED.value())
                .message("Salon created successfully")
                .data(salon)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a salon", description = "Update an existing salon's details", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Salon updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SalonDto.class)))
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SalonDto>> updateSalon(@PathVariable Long id, @Valid @RequestBody SalonRequestDto salonRequestDto) {
        SalonDto updatedSalon = salonService.updateSalon(id, salonRequestDto);
        ApiResponse<SalonDto> response = ApiResponse.<SalonDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Salon updated successfully")
                .data(updatedSalon)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete a salon", description = "Delete a salon by its ID", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Salon deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSalon(@PathVariable Long id) {
        salonService.deleteSalon(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NO_CONTENT.value())
                .message("Salon deleted successfully")
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
