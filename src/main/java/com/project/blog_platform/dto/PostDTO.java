package com.project.blog_platform.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDTO {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
}
