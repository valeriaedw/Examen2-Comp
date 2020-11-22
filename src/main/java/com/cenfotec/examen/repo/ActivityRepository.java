package com.cenfotec.examen.repo;

import com.cenfotec.examen.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Long> {
    public List<Activity> findByNameContaining(String word);
}
