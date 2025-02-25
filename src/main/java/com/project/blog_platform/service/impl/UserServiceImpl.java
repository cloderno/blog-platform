package com.project.blog_platform.service.impl;

import com.project.blog_platform.dto.UserDTO;
import com.project.blog_platform.mapper.UserMapper;
import com.project.blog_platform.model.User;
import com.project.blog_platform.repository.UserRepository;
import com.project.blog_platform.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        log.info("Created user with ID: {}", user.getId());
        return userMapper.toDto(user);
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();

        return userList.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        if (!userRepository.existsById(id)) {
            log.warn("User with ID {} not found", id);
            throw new RuntimeException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
        log.info("Deleted user with ID: {}", id);

        // existsbyid + deleteby id would be better optimized
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//
//        userRepository.delete(user);
    }
}
