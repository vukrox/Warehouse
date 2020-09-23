package com.braun.dao;

import com.braun.units.Article;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;


/*
 *DAO JDBC implementation. Couldn't connect to HSQL DB - using MySQL DB connection instead.
 */

public class ArticleDaoImpl implements ArticleDAO {

    private JdbcTemplate jdbcTemplate;

    private static final String CREATE_TABLE_SQL = "create table if not exists WAREHOUSE.ARTICLE (\n" +
            "id integer not null auto_increment primary key, \n" +
            "name VARCHAR (512) NOT NULL, \n" +
            "description VARCHAR(1024), \n" +
            "creation_date DATE , \n" +
            "storage_place INTEGER , \n" +
            "reserved BOOLEAN DEFAULT FALSE NOT NULL);";

    //The constructor for DependencyInjection.
    public ArticleDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void createTables() {
        try {
            jdbcTemplate.execute(CREATE_TABLE_SQL);
        } catch (BadSqlGrammarException e) {
            System.out.println("Assuming that the table already exists");
        }
    }

    @Override
    public int save(Article newArticle) {

        String sqlInsert = "INSERT INTO warehouse.article (NAME, DESCRIPTION, CREATION_DATE, STORAGE_PLACE, RESERVED) VALUES (?,?,?,?,?);";

        return jdbcTemplate.update(sqlInsert,
                newArticle.getName(),
                newArticle.getDescription(),
                newArticle.getCreationDate(),
                newArticle.getStoragePlace(),
                newArticle.isReserved());
    }

    @Override
    public int update(Article oldArticle) {

        String sqlUpdate = "UPDATE warehouse.article SET NAME=?, DESCRIPTION =?, CREATION_DATE=?, STORAGE_PLACE= ?,RESERVED=? WHERE id=?";
        return jdbcTemplate.update(sqlUpdate,
                oldArticle.getName(),
                oldArticle.getDescription(),
                oldArticle.getCreationDate(),
                oldArticle.getStoragePlace(),
                oldArticle.isReserved(),
                oldArticle.getId());
    }

    @Override
    public Article get(Integer articleId) {
        String sqlGet = "SELECT * FROM warehouse.article WHERE id=" + articleId;

        ResultSetExtractor<Article> extractor = new ResultSetExtractor<Article>() {
            @Override
            public Article extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    String description = resultSet.getString("DESCRIPTION");

                    java.sql.Date dateToConvert = resultSet.getDate("CREATION_DATE");
                    LocalDate date = convertToLocalDateViaSqlDate(dateToConvert);

                    int storagePlace = resultSet.getInt("STORAGE_PLACE");
                    boolean reserved = resultSet.getBoolean("RESERVED");

                    return new Article(articleId, name, description, date, storagePlace, reserved);
                } else {
                    return null;
                }
            }
        };
        return jdbcTemplate.query(sqlGet, extractor);
    }

    @Override
    public int delete(Integer id) {
        String sqlDelete = "DELETE FROM warehouse.article WHERE id=" + id;
        return jdbcTemplate.update(sqlDelete);
    }

    @Override
    public List<Article> allArticles() {

        String sqlChooseAll = "SELECT * FROM warehouse.article";

        RowMapper<Article> artMapper = new RowMapper<Article>() {

            @Override
            public Article mapRow(ResultSet resultSet, int rowNum) throws SQLException {

                Article article = null;

                Integer articleId = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");

                java.sql.Date dateToConvert = resultSet.getDate("CREATION_DATE");
                LocalDate date = convertToLocalDateViaSqlDate(dateToConvert);

                int storagePlace = resultSet.getInt("STORAGE_PLACE");
                boolean reserved = resultSet.getBoolean("RESERVED");

                article = new Article(articleId, name, description, date, storagePlace, reserved);

                return article;
            }
        };
        return jdbcTemplate.query(sqlChooseAll, artMapper);
    }

    private LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
//        LocalDateTime date = new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime();
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
//        return date;
    }
}
