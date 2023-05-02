package com.sagemcom.msarticle.contollers;

import com.sagemcom.msarticle.entities.Article;
import com.sagemcom.msarticle.generic.RestControllerGeneric;
import com.sagemcom.msarticle.services.ArticleServ;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("article")
public class ArticleCont extends RestControllerGeneric<Article , Long>{
    private final ArticleServ articleServ;
}
