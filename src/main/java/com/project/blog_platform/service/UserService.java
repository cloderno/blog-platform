package com.project.blog_platform.service;

import com.project.blog_platform.dto.UserDTO;
import com.project.blog_platform.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    Optional<UserDTO> getUserById(Long id); // optional - This way, the 404 can be handled more elegantly in the Controller.
    List<UserDTO> getAllUsers();
    void deleteUser(Long id);
}
