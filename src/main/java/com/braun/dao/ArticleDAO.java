package com.braun.dao;

import com.braun.units.Article;

import java.util.List;

public interface ArticleDAO {

    public int save(Article newArticle);
    public int update(Article oldArticle);
    public Article get(Integer contactId);
    public int delete(Integer id);
    public List<Article> allArticles();
}
