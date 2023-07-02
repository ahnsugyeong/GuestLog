package com.suddiyo.springboot.service.posts;

import com.suddiyo.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String picture;
    private String createdDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.createdDate = entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy. M. d. a h:mm"));
        this.picture = entity.getMember().getPicture();
    }
}
