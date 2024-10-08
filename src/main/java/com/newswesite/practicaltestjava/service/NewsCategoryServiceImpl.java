package com.newswesite.practicaltestjava.service;

import com.newswesite.practicaltestjava.model.NewsCategory;
import com.newswesite.practicaltestjava.model.NewsItems;
import com.newswesite.practicaltestjava.repository.NewsCategoryRepository;
import com.newswesite.practicaltestjava.repository.NewsItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsCategoryServiceImpl implements NewsService{

    private NewsCategoryRepository newsCategoryRepository;
    private NewsItemRepository newsItemRepository;

    @Override
    public ResponseEntity<List<NewsCategory>> getAllNewsCategories() {

        List<NewsCategory> allCategoris;
        try{
            allCategoris=newsCategoryRepository.findAll();
            return new ResponseEntity<>(allCategoris, HttpStatus.OK);
        }catch (Exception e){
            //If throw exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<NewsItems>> getHeadlinesByCategory(String shortId) {

        List<NewsItems> headingsByCategory;
        try{
            headingsByCategory=newsItemRepository.findAllByShortId(shortId);
            return new ResponseEntity<>(headingsByCategory,HttpStatus.OK);
        }catch (Exception e){
            //If throw exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<NewsItems> getNewsBody(int id) {

        try{
            NewsItems newsItems=newsItemRepository.findById(id).get();
            return new ResponseEntity<>(newsItems,HttpStatus.OK);
        }catch (Exception e){
            //If throw exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<NewsItems> addComment(NewsItems newsItems, int id) {

        NewsItems newsItemsToAddComent=null;
        NewsItems respone=null;
        System.out.println(id);
        System.out.println(newsItems.getComment());
        try{
            //News Item find by ID
            newsItemsToAddComent=newsItemRepository.findById(id).get();
            //Add comment to relevent news item
            newsItemsToAddComent.setComment(newsItems.getComment());
            if(!newsItemsToAddComent.equals(null)){
                //Save relevent news item
                respone= newsItemRepository.save(newsItemsToAddComent);
                return new ResponseEntity<>(respone,HttpStatus.OK);
            }else {
                //If used doesn't exist
                return new ResponseEntity<>(respone,HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            //If throw exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
