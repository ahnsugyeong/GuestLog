package com.suddiyo.springboot.web.dto;

import com.suddiyo.springboot.domain.posts.Posts;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Long memberId;



    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.memberId = entity.getMember().getId();
    }
}
