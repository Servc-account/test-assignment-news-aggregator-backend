package com.newsaggregator.controller;

import com.newsaggregator.dto.NewsDto;
import com.newsaggregator.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;
    
    @GetMapping
    public List<NewsDto> getAllNews() {
        return this.newsService.getAllNews();
    }
}