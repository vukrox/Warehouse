package com.braun.services;

import com.braun.dao.ArticleDAO;
import com.braun.units.Article;

import java.util.List;

/*
 * PaddingClass for the user interaction and implementation of the business logic, exceptions handling here. Needs improvement.
 */

public class ArticleServiceImpl implements ArticleService {

    private ArticleDAO dao;

    public ArticleServiceImpl(ArticleDAO dao) {
        this.dao = dao;
    }

    @Override
    public int createNewArticle(Article newArticle) {
        return dao.save(newArticle);
    }

    @Override
    public int updateExistingArticle(Article oldArticle) {
        return dao.update(oldArticle);
    }

    @Override
    public Article getArticleById(Integer neededArticleId) {
        return dao.get(neededArticleId);
    }

    @Override
    public int removeArticle(Integer oldArticleId) {
        return dao.delete(oldArticleId);
    }

    @Override
    public List<Article> printTheWholeArticleList() {
        return dao.allArticles();
    }
}
