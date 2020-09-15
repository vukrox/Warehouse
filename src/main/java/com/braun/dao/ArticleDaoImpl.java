package com.braun.dao;

import com.braun.units.Article;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ArticleDaoImpl implements ArticleDAO {

    private JdbcTemplate jdbcTemplate;

    public ArticleDaoImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Article newArticle) {
        return 0;
    }

    @Override
    public int update(Article oldArticle) {
        return 0;
    }

    @Override
    public Article get(Integer contactId) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public List<Article> allArticles() {
        return null;
    }
}
