package com.org.salonBooking.api.user.service.impl;

import com.org.salonBooking.common.exception.ResourceNotFoundException;
import com.org.salonBooking.common.service.impl.BaseServiceImpl;
import com.org.salonBooking.api.user.dto.UserCreateDto;
import com.org.salonBooking.api.user.dto.UserDto;
import com.org.salonBooking.api.user.dto.UserUpdateDto;
import com.org.salonBooking.api.user.entity.User;
import com.org.salonBooking.api.user.repository.UserRepository;
import com.org.salonBooking.api.user.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplement extends BaseServiceImpl<User, Long> implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected JpaRepository<User, Long> getRepository() { return userRepository; }

    @Override
    protected String getEntityName() { return "User"; }

    @Override
    public UserDto getUserById(Long id) {
        User user = findById(id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserByName(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("User", "name", name));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return findAll(pageable).map(user -> modelMapper.map(user, UserDto.class));
    }

    @Override
    public UserDto createUser(UserCreateDto userDto) {

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new DataIntegrityViolationException("Email already exists.");
        }

        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = create(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userDto) {
        User user = findById(id);

        if (userDto.getEmail() != null && !user.getEmail().equals(userDto.getEmail()) && userRepository.existsByEmail(userDto.getEmail())) {
            throw new DataIntegrityViolationException("Email already exists.");
        }

        Optional.ofNullable(userDto.getName())
                .filter(name -> !name.isEmpty())
                .ifPresent(user::setName);

        Optional.ofNullable(userDto.getEmail())
                .filter(email -> !email.isEmpty())
                .ifPresent(user::setEmail);

        Optional.ofNullable(userDto.getIsPremium())
                .ifPresent(user::setIsPremium);

        Optional.ofNullable(userDto.getRole())
                .ifPresent(user::setRole);

        User updatedUser = update(id, user);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public Page<UserDto> searchUsers(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Page<UserDto> getUsersByName(String username, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteUser(Long id) { delete(id); }
}
