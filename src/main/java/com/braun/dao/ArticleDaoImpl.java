package com.braun.dao;

import com.braun.units.Article;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ArticleDaoImpl implements ArticleDAO {

    private static final String CREATE_TABLE_SQL = "create table ARTICLE (id int not null,name varchar (512), description VARCHAR(1024), creationDate 'yyy-MM-dd', storagePlace int, reserved boolean default false not null)";


    private JdbcTemplate jdbcTemplate;

    public ArticleDaoImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private void createTables()
    {
        try
        {
            jdbcTemplate.update(CREATE_TABLE_SQL);
        }
        catch (BadSqlGrammarException e)
        {
            System.out.println("Assuming that the table already exists");
        }
    }

    @Override
    public int save(Article newArticle) {
        String sqlInsert = "INSERT INTO Article (name, description,creatioDate, storagePlace, reserved) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(sqlInsert,  newArticle.getName(),
                                        newArticle.getDescription(),
                                        newArticle.getCreatioDate(),
                                        newArticle.getStoragePlace(),
                                        newArticle.isReserved());
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
