package com.cenfotec.examen.service.category;

import com.cenfotec.examen.domain.Category;
import com.cenfotec.examen.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository repo;
    @Override
    public void save(Category category) {
        repo.save(category);
    }

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Category> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Category> find(String name) {
        return repo.findByNameContaining(name);
    }
}
