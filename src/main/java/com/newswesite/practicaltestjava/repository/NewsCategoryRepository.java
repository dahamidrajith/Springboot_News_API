package com.newswesite.practicaltestjava.repository;

import com.newswesite.practicaltestjava.model.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCategoryRepository extends JpaRepository<NewsCategory,Integer> {
}
