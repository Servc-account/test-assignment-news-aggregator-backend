package com.newsaggregator.service.impl;

import com.newsaggregator.dto.NewsDto;
import com.newsaggregator.entity.News;
import com.newsaggregator.repository.NewsRepository;
import com.newsaggregator.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsServiceImpl implements NewsService {
    
    private final NewsRepository newsRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<NewsDto> getAllNews() {
        return newsRepository.findAllByOrderByPublishedAtDesc()
                .stream()
                .map(this::toDto)
                .toList();
    }
    
    private NewsDto toDto(News news) {
        return NewsDto.builder()
                .id(news.getId())
                .title(news.getTitle())
                .description(news.getDescription())
                .sourceUrl(news.getSourceUrl())
                .source(news.getSource())
                .publishedAt(news.getPublishedAt())
                .createdAt(news.getCreatedAt())
                .build();
    }
}