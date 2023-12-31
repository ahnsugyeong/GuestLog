package com.suddiyo.springboot.web;

import com.suddiyo.springboot.config.auth.LoginUser;
import com.suddiyo.springboot.config.auth.dto.SessionUser;
import com.suddiyo.springboot.service.posts.PostsService;
import com.suddiyo.springboot.web.dto.PostsResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postService.findAllDesc());

        /*
        세션에 저장된 값이 있을 때만 model에 userName으로 등록.
        세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태니 로그인 버튼이 보임
         */
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("profileImg", user.getPicture());
            model.addAttribute("email", user.getEmail());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user) {
        model.addAttribute("userName", user.getName());
        return "posts-save";
    }

    @GetMapping("/posts/{id}")
    public String posts(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        if(user != null && dto.getMemberId().equals(user.getMemberId())) {
            model.addAttribute("isAuthor", true);
        }

        return "posts-main";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, @LoginUser SessionUser user, Model model) {
        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        if (!dto.getMemberId().equals(user.getMemberId())) {
            return "posts-main";
        }

        return "posts-update";
    }


}
