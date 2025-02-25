package com.project.blog_platform.mapper;

import com.project.blog_platform.dto.UserDTO;
import com.project.blog_platform.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = PostMapper.class)
public interface UserMapper {
    @Mapping(target = "id", ignore = true) // ignoring id because DB generates itself
    User toEntity(UserDTO userDTO);

    UserDTO toDto(User user);
}
