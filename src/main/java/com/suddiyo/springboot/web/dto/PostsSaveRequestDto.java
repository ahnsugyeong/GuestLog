package com.suddiyo.springboot.web.dto;

import com.suddiyo.springboot.domain.posts.Posts;
import com.suddiyo.springboot.domain.user.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private Long memberId;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, Member member) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.memberId = member.getId();
    }

    public Posts toEntity(Member member) {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .member(member)
                .build();
    }

    public void updateMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public void updateAuthor(String author) {
        this.author = author;
    }
}
