package com.org.salonBooking.api.user.controller;

import com.org.salonBooking.api.user.dto.UserUpdateDto;
import com.org.salonBooking.common.response.ApiResponse;
import com.org.salonBooking.api.user.dto.UserCreateDto;
import com.org.salonBooking.api.user.dto.UserDto;
import com.org.salonBooking.api.user.service.UserService;
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
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "Operations related to users")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get user by ID", description = "Retrieve a user by their ID", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User retrieved successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)))
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        ApiResponse<UserDto> response = ApiResponse.<UserDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("User retrieved successfully")
                .data(user)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all users", description = "Retrieve a list of users with pagination", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Users retrieved successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)))
    @GetMapping
    public ResponseEntity<ApiResponse<Page<UserDto>>> getAllUsers(Pageable pageable) {
        Page<UserDto> users = userService.getAllUsers(pageable);
        ApiResponse<Page<UserDto>> response = ApiResponse.<Page<UserDto>>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Users retrieved successfully")
                .data(users)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new user", description = "Create a new user by providing user details", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "User created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)))
    @PostMapping
    public ResponseEntity<ApiResponse<UserDto>> createUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        UserDto user = userService.createUser(userCreateDto);
        ApiResponse<UserDto> response = ApiResponse.<UserDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED.value())
                .message("User created successfully")
                .data(user)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a user", description = "Update an existing user's details", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class)))
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
        UserDto updatedUser = userService.updateUser(id, userUpdateDto);
        ApiResponse<UserDto> response = ApiResponse.<UserDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("User updated successfully")
                .data(updatedUser)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete a user", description = "Delete a user by their ID", security = @SecurityRequirement(name = "bearerAuth"))
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "User deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NO_CONTENT.value())
                .message("User deleted successfully")
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
