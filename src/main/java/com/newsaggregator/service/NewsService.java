package com.newsaggregator.service;

import com.newsaggregator.dto.NewsDto;

import java.util.List;

public interface NewsService {
    List<NewsDto> getAllNews();
}