package com.cenfotec.examen.service.category;

import com.cenfotec.examen.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void save(Category category);
    public List<Category> getAll();
    public Optional<Category> get(Long id);
    public List<Category> find(String name);
}
