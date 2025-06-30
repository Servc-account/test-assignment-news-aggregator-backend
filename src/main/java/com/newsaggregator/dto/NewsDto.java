package com.newsaggregator.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private Long id;
    private String title;
    private String description;
    private String sourceUrl;
    private String source;
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;
}