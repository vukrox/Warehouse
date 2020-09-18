import com.braun.dao.ArticleDAO;
import com.braun.dao.ArticleDaoImpl;
import com.braun.units.Article;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleDaoTest {

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/warehouse?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String PASSWORD = "Na4uhudonossor";
    private static final String USERNAME = "root";

    private DriverManagerDataSource dataSource;
    private ArticleDAO dao;

    @BeforeEach
    void setupBeforeEach() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_NAME);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        dao = new ArticleDaoImpl(dataSource);
    }

    @Test
    @Ignore
    void testSave() {
        Article testArticle = new Article("Computer", "MacBook", new GregorianCalendar(2020, 9, 15), 10, false);
        int result = dao.save(testArticle);

        assertTrue(result > 0);
    }

    @Test
    @Ignore
    void testUpdate() {
        Article testArticle = new Article(3, "Computer", "Dell", new GregorianCalendar(2020, 10, 15), 10, false);
        int result = dao.update(testArticle);

        assertTrue(result > 0);
    }

    @Test
    @Ignore
    void testGet() {
        Integer id = 2;
        Article article = dao.get(id);
        if (article != null) {
            System.out.println(article);
        } else {
            System.out.println("Article doesn't exist");
        }
        assertNotNull(article);
    }

    @Test
    @Ignore
    void testDelete() {
        Integer id = 2;
        int result = dao.delete(id);

        assertTrue(result > 0);
    }

    @Test
    void testAllArticles() {
        List<Article> articleList = dao.allArticles();

//        articleList.stream()
//        .flatMap(x -> x.entrySet().stream())
//        .forEach(entry -> System.out.println("k: "+ entry.getKey() + " v: " + entry.getValue()));

        for (Article nextArticle: articleList) {
            System.out.println(nextArticle);
        }
        assertTrue(!articleList.isEmpty());
        assertEquals(2, articleList.size());
    }
}