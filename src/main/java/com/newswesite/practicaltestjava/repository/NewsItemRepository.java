package com.newswesite.practicaltestjava.repository;

import com.newswesite.practicaltestjava.model.NewsItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsItemRepository extends JpaRepository<NewsItems,Integer> {
    List<NewsItems> findAllByShortId(String shortId);
}
