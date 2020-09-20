package com.braun.controller;

import com.braun.dao.ArticleDAO;
import com.braun.units.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ArticleDAO articleDAO;

    @RequestMapping(value = "/")
    public ModelAndView listContact(ModelAndView model) {
        List<Article> articles = articleDAO.allArticles();
        model.addObject("articles", articles);
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView newArticle(ModelAndView model) {
        Article newArticle = new Article();
        model.addObject("article", newArticle);
        model.setViewName("article_form");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveArticle(@ModelAttribute Article article) {

            articleDAO.save(article);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editArticle(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Article article = articleDAO.get(id);

        ModelAndView model = new ModelAndView("article_form");
        model.addObject("article", article);

        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteArticle(@RequestParam Integer id) {
        articleDAO.delete(id);

        return new ModelAndView("redirect:/");
    }
}
