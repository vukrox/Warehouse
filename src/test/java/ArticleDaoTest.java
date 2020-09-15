import com.braun.dao.ArticleDAO;

import com.braun.dao.ArticleDaoImpl;
import com.braun.units.Article;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleDaoTest {

    private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
    private static final String DATABASE_URL = "jdbc:hsqldb:file:article;shutdown=true";
    private static final String PASSWORD = "";
    private static final String USERNAME = "sa";

    private DriverManagerDataSource dataSource;
    private ArticleDAO dao;

    @Test
    void testSave(){
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_NAME);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        dao = new ArticleDaoImpl(dataSource);

        Article testArticle = new Article("Computer","MacBook",new GregorianCalendar(2020,9,15),10,false);
        int result = dao.save(testArticle);

        assertTrue(result >0);
    }

    @Test
    void testUpdate(){
        fail();
    }

    @Test
    void testGet(){
        fail();
    }

    @Test
    void testDelete(){
        fail();
    }

    @Test
    void testAllArticles(){
        fail();
    }
}
