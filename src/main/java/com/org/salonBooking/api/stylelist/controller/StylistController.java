package com.org.salonBooking.api.stylelist.controller;

import com.org.salonBooking.api.stylelist.dto.StylistCreateDto;
import com.org.salonBooking.api.stylelist.dto.StylistDto;
import com.org.salonBooking.api.stylelist.dto.StylistUpdateDto;
import com.org.salonBooking.api.stylelist.service.StylistService;
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
@RequestMapping("/stylists")
@RequiredArgsConstructor
@Tag(name = "Stylist", description = "Operations related to stylists")
public class StylistController {

    private final StylistService stylistService;

    @Operation(summary = "Get stylist by ID", description = "Retrieve a stylist by their ID", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Stylist retrieved successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StylistDto.class)))
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StylistDto>> getStylistById(@PathVariable Long id) {
        StylistDto stylist = stylistService.getStylistById(id);
        ApiResponse<StylistDto> response = ApiResponse.<StylistDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Stylist retrieved successfully")
                .data(stylist)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all stylists", description = "Retrieve a list of stylists with pagination", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Stylists retrieved successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StylistDto.class)))
    @GetMapping
    public ResponseEntity<ApiResponse<Page<StylistDto>>> getAllStylists(Pageable pageable) {
        Page<StylistDto> stylists = stylistService.getAllStylists(pageable);
        ApiResponse<Page<StylistDto>> response = ApiResponse.<Page<StylistDto>>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Stylists retrieved successfully")
                .data(stylists)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new stylist", description = "Create a new stylist by providing stylist details", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Stylist created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StylistDto.class)))
    @PostMapping
    public ResponseEntity<ApiResponse<StylistDto>> createStylist(@Valid @RequestBody StylistCreateDto stylistCreateDto) {
        StylistDto stylist = stylistService.createStylist(stylistCreateDto);
        ApiResponse<StylistDto> response = ApiResponse.<StylistDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED.value())
                .message("Stylist created successfully")
                .data(stylist)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a stylist", description = "Update an existing stylist's details", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Stylist updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StylistDto.class)))
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StylistDto>> updateStylist(@PathVariable Long id, @Valid @RequestBody StylistUpdateDto stylistUpdateDto) {
        StylistDto updatedStylist = stylistService.updateStylist(id, stylistUpdateDto);
        ApiResponse<StylistDto> response = ApiResponse.<StylistDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Stylist updated successfully")
                .data(updatedStylist)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete a stylist", description = "Delete a stylist by their ID", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Stylist deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStylist(@PathVariable Long id) {
        stylistService.deleteStylist(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NO_CONTENT.value())
                .message("Stylist deleted successfully")
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @Operation(summary = "Change salon for stylist", description = "Change the salon of a stylist", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Salon changed successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StylistDto.class)))
    @PatchMapping("/{id}/change-salon/{salonId}")
    public ResponseEntity<ApiResponse<StylistDto>> changeSalon(@PathVariable Long id, @PathVariable Long salonId) {
        StylistDto updatedStylist = stylistService.changeSalon(id, salonId);
        ApiResponse<StylistDto> response = ApiResponse.<StylistDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Salon changed successfully")
                .data(updatedStylist)
                .build();
        return ResponseEntity.ok(response);
    }
}
