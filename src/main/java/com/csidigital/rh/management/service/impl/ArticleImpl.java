package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Article;

import com.csidigital.rh.dao.repository.ArticleRepository;
import com.csidigital.rh.management.service.ArticleService;
import com.csidigital.rh.shared.dto.request.ArticleRequest;
import com.csidigital.rh.shared.dto.response.ArticleResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class ArticleImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArticleResponse createArticle (ArticleRequest request) {
        Article article = modelMapper.map(request, Article.class);
        Article ArticleSaved = articleRepository.save(article);
        return modelMapper.map(ArticleSaved, ArticleResponse.class);
    }

    @Override
    public List<ArticleResponse> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleResponse> articleList = new ArrayList<>();

        for (Article article : articles) {
            ArticleResponse response = modelMapper.map(article, ArticleResponse.class);
           articleList.add(response);
        }

        return articleList;
    }

    @Override
    public ArticleResponse getArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Article with id " +id+ " not found"));
        ArticleResponse articleResponse = modelMapper.map(article, ArticleResponse.class);
        return articleResponse;
    }

    @Override
    public ArticleResponse updateArticle(ArticleRequest request, Long id) {
        Article existingArticle = articleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Article with id: " + id + " not found"));
        modelMapper.map(request, existingArticle);
        Article savedArticle = articleRepository.save(existingArticle);
        return modelMapper.map(savedArticle, ArticleResponse.class);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

}
