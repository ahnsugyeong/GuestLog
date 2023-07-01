package com.suddiyo.springboot.service.posts;

import com.suddiyo.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String picture;
    private String modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

        this.picture = entity.getMember().getPicture();
    }
}
