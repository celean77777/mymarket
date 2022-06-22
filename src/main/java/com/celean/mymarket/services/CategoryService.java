package com.celean.mymarket.services;

import com.celean.mymarket.model.Category;
import com.celean.mymarket.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
       return categoryRepository.findByTitle(title);
    }
}
