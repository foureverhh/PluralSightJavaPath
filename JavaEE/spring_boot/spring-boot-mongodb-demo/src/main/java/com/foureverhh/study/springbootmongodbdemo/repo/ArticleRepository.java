package com.foureverhh.study.springbootmongodbdemo.repo;

import com.foureverhh.study.springbootmongodbdemo.domain.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ArticleDao extends MongoRepository<Article,Integer> {

}
