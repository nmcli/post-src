package com.example.post.controller;

import com.example.post.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class PostController {

    private final List<Post> posts = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(3); // 1,2는 초기값에서 사용함

    public PostController() {
        posts.add(new Post(1L, "첫 번째 글", "내용입니다", "홍길동", LocalDateTime.now()));
        posts.add(new Post(2L, "두 번째 글", "내용입니다", "이몽룡", LocalDateTime.now()));
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String list(Model model) {
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/posts/new")
    public String showForm(Model model) {
        model.addAttribute("post", new Post()); // 폼 바인딩용 빈 객체
        return "post/new"; // /WEB-INF/views/post/new.jsp
    }

    @PostMapping("/posts")
    public String save(@ModelAttribute Post post) {
        post.setId(idGenerator.getAndIncrement());
        post.setCreatedAt(LocalDateTime.now());
        posts.add(post);
        return "redirect:/posts";
    }
}
