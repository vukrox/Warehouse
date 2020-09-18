package com.braun.configue;

import com.braun.dao.ArticleDAO;
import com.braun.dao.ArticleDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan (basePackages = "com.braun")
public class SpringMvcConfig implements WebMvcConfigurer {

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/warehouse?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String PASSWORD = "Na4uhudonossor";
    private static final String USERNAME = "root";

    @Bean
    public DataSource getDataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_NAME);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

    @Bean
    public ViewResolver getViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public ArticleDAO getArticleDAO(){
        ArticleDAO dao = new ArticleDaoImpl(getDataSource());

        return dao;
    }
}