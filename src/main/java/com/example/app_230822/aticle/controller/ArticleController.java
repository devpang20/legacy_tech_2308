package com.example.app_230822.aticle.controller;

import com.example.app_230822.aticle.dto.Article;
import com.example.app_230822.aticle.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList =  articleService.getArticles();

        model.addAttribute("articleList", articleList);
        return "article/list";
    }

    @GetMapping("/article/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
           Article article = articleService.getArticleById(id);
            model.addAttribute("article", article);

            return "article/detail";
        }
}
