package com.newswesite.practicaltestjava.service;

import com.newswesite.practicaltestjava.model.NewsCategory;
import com.newswesite.practicaltestjava.model.NewsItems;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {
    public ResponseEntity<List<NewsCategory>> getAllNewsCategories();

    public ResponseEntity<List<NewsItems>> getHeadlinesByCategory(String shortId);

    public ResponseEntity<NewsItems> getNewsBody(int id);

    public ResponseEntity<NewsItems> addComment(NewsItems newsItems, int id);
}
