package com.cenfotec.examen.service.workshop;

import com.cenfotec.examen.domain.WorkShop;
import com.cenfotec.examen.repo.WorkShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkShopServiceImpl implements WorkShopService{
    @Autowired
    WorkShopRepository repo;
    @Override
    public void save(WorkShop workshop) {
        repo.save(workshop);
    }

    @Override
    public List<WorkShop> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<WorkShop> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<WorkShop> find(String name) {
        return repo.findByNameContaining(name);
    }

    @Override
    public List<WorkShop> findByCategory(String category) {
        return repo.findByCategory(category);
    }

    @Override
    public List<WorkShop> findByAutor(String autor) {
        return repo.findByAutor(autor);
    }

    @Override
    public List<WorkShop> findByKeyword(String keyword) {
        return repo.findByKeyword(keyword);
    }


}
