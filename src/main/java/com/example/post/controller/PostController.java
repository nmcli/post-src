package com.example.post.controller;

import com.example.post.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private List<Post> posts = new ArrayList<>();

    // 임시 데이터 추가
    public PostController() {
        posts.add(new Post(1L, "첫 번째 글", "내용입니다", "홍길동", LocalDateTime.now()));
        posts.add(new Post(2L, "두 번째 글", "내용입니다", "이몽룡", LocalDateTime.now()));
    }

    @GetMapping("/posts")
    public String list(Model model) {
        model.addAttribute("posts", posts);
        return "post/list"; // /WEB-INF/views/post/list.jsp
    }
}
