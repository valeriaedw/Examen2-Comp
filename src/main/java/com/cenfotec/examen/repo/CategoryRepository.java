package com.cenfotec.examen.repo;

import com.cenfotec.examen.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public List<Category> findByNameContaining(String word);
}
