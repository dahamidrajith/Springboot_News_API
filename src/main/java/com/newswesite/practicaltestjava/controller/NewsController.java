package com.newswesite.practicaltestjava.controller;

import com.newswesite.practicaltestjava.model.NewsCategory;
import com.newswesite.practicaltestjava.model.NewsItems;
import com.newswesite.practicaltestjava.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@AllArgsConstructor
public class NewsController {

    private NewsService newsService;

    //Get al the News Categoris
    @GetMapping("/getallnewcategories")
    public ResponseEntity<List<NewsCategory>> getAllNewsCategories(){
        return newsService.getAllNewsCategories();
    }

    //Get News Heading by Category
    @GetMapping("/getheadlinebycategory/{shortId}")
    public ResponseEntity<List<NewsItems>> getHeadlinesByCategory(@PathVariable String shortId){
        return newsService.getHeadlinesByCategory(shortId);
    }

    //Get News Body
    @GetMapping("/getnewsbody/{id}")
    private ResponseEntity<NewsItems> getNewsBody(@PathVariable int id){
        return newsService.getNewsBody(id);
    }

    //add Comment
    @PutMapping("/addcomment/{id}")
    public ResponseEntity<NewsItems> addComment(@RequestBody NewsItems newsItems, @PathVariable int id){
        return newsService.addComment(newsItems,id);
    }

}
