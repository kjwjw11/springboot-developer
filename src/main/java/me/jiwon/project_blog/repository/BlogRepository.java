package me.jiwon.project_blog.repository;

import me.jiwon.project_blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
