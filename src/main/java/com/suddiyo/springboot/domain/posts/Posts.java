package com.suddiyo.springboot.domain.posts;

import com.suddiyo.springboot.domain.BaseTimeEntity;
import com.suddiyo.springboot.domain.user.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Posts(String title, String content, String author, Member member) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.member = member;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
