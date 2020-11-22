package com.cenfotec.examen.service.workshop;


import com.cenfotec.examen.domain.WorkShop;


import java.util.List;
import java.util.Optional;

public interface WorkShopService {
    public void save(WorkShop workshop);
    public List<WorkShop> getAll();
    public Optional<WorkShop> get(Long id);
    public List<WorkShop> find(String name);
    public List<WorkShop> findByCategory(String category);
    public List<WorkShop> findByAutor(String autor);
    public List<WorkShop> findByKeyword( String keyword);

}
