package com.newsaggregator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    private String description;
    
    @Column(nullable = false, unique = true)
    private String sourceUrl;
    
    @Column(nullable = false)
    private String source;
    
    @Column(nullable = false)
    private LocalDateTime publishedAt;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
}