package com.cenfotec.examen.service.activity;

import com.cenfotec.examen.domain.Activity;
import com.cenfotec.examen.repo.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityRepository repo;

    @Override
    public void save(Activity activity) {
        repo.save(activity);
    }

    @Override
    public List<Activity> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Activity> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Activity> find(String name) {
        return repo.findByNameContaining(name);
    }
}
