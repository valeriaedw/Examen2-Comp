package com.cenfotec.examen.service.activity;


import com.cenfotec.examen.domain.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    void save(Activity activity);
    public List<Activity> getAll();
    public Optional<Activity> get(Long id);
    public List<Activity> find(String name);
}
