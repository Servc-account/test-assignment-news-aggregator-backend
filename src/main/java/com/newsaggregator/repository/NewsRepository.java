package com.newsaggregator.repository;

import com.newsaggregator.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByOrderByPublishedAtDesc();
    boolean existsBySourceUrl(String sourceUrl);
}