package com.sagemcom.msarticle.repositories;

import com.sagemcom.msarticle.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository <Article, Long> {
}
