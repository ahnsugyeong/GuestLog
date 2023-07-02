package com.suddiyo.springboot.web;

import com.suddiyo.springboot.config.auth.LoginUser;
import com.suddiyo.springboot.config.auth.dto.SessionUser;
import com.suddiyo.springboot.service.posts.PostsService;
import com.suddiyo.springboot.web.dto.PostsResponseDto;
import com.suddiyo.springboot.web.dto.PostsSaveRequestDto;
import com.suddiyo.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto, @LoginUser SessionUser user) {
        requestDto.updateMemberId(user.getMemberId());
        requestDto.updateAuthor(user.getName());
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto, @LoginUser SessionUser user) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
