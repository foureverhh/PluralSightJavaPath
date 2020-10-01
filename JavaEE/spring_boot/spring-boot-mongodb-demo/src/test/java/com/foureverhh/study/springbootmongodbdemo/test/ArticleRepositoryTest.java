package com.foureverhh.study.springbootmongodbdemo.test;

import com.foureverhh.study.springbootmongodbdemo.SpringBootMongodbDemoApplication;
import com.foureverhh.study.springbootmongodbdemo.domain.Article;
import com.foureverhh.study.springbootmongodbdemo.repo.ArticleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootMongodbDemoApplication.class)
public class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDaoImpl;
    @Test
    public void testSave(){
        Article article = new Article();
        article.setId(1);
        article.setName("black horse");
        article.setContent("black horse content");
        article.setHits(100);
        articleDaoImpl.save(article);
    }
}
