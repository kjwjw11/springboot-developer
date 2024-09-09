package me.jiwon.project_blog.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.jiwon.project_blog.domain.Article;
import me.jiwon.project_blog.dto.AddArticleRequest;
import me.jiwon.project_blog.dto.UpdateArticleRequest;
import me.jiwon.project_blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    // 블로그 글 리스트 조회
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // 블로그 글  id 조회
    public Article findById(long id){
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 블로그 글  id 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    // 블로그 글  수정
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
