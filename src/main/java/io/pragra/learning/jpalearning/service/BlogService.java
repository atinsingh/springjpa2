package io.pragra.learning.jpalearning.service;

import io.pragra.learning.jpalearning.repo.BlogRepo;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private BlogRepo repo;

    public BlogService(BlogRepo repo) {
        this.repo = repo;
    }

}
