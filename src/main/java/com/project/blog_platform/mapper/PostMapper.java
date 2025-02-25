package com.project.blog_platform.mapper;

import com.project.blog_platform.dto.PostDTO;
import com.project.blog_platform.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface PostMapper {
    PostDTO toDto(Post post);

    Post toEntity(PostDTO postDTO);
}
