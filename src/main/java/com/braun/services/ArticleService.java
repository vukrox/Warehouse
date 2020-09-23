package com.braun.services;

import com.braun.units.Article;

import java.util.List;

public interface ArticleService {
    public int createNewArticle(Article newArticle);

    public int updateExistingArticle(Article oldArticle);

    public Article getArticleById(Integer neededArticleId);

    public int removeArticle(Integer oldArticleId);

    public List<Article> printTheWholeArticleList();

}
