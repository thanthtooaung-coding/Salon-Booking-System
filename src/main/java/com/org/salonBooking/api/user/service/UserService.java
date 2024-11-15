package com.org.salonBooking.api.user.service;

import com.org.salonBooking.common.service.BaseService;
import com.org.salonBooking.api.user.dto.UserCreateDto;
import com.org.salonBooking.api.user.dto.UserDto;
import com.org.salonBooking.api.user.dto.UserUpdateDto;
import com.org.salonBooking.api.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends BaseService<User, Long> {
    UserDto getUserById(Long id);
    UserDto getUserByUsername(String username);
    UserDto getUserByEmail(String email);
    Page<UserDto> getAllUsers(Pageable pageable);
    UserDto createUser(UserCreateDto userDto);
    UserDto updateUser(Long id, UserUpdateDto userDto);
    Page<UserDto> searchUsers(String keyword, Pageable pageable);// TODO
    Page<UserDto> getUsersByUsername(String username, Pageable pageable); // TODO
    void deleteUser(Long id);
}
