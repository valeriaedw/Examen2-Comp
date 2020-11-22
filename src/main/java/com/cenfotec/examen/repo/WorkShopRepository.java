package com.cenfotec.examen.repo;

import com.cenfotec.examen.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cenfotec.examen.domain.WorkShop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkShopRepository extends JpaRepository<WorkShop,Long>{
    public List<WorkShop> findByNameContaining(String word);

    @Query(value = "SELECT * FROM WORK_SHOP INNER JOIN CATEGORY ON WORK_SHOP.CART_ID = CATEGORY.ID WHERE CATEGORY.NAME = :category", nativeQuery = true)
    List<WorkShop> findByCategory(@Param("category") String category);

    @Query(value = "SELECT * FROM WORK_SHOP WHERE WORK_SHOP.AUTOR =  :autor",nativeQuery = true)
    public List<WorkShop> findByAutor(@Param("autor") String autor);

    @Query(value = "SELECT * FROM WORK_SHOP WHERE WORK_SHOP.KEYWORD1=:keyword OR WORK_SHOP.KEYWORD2= :keyword OR WORK_SHOP.KEYWORD3= :keyword",nativeQuery = true)
    public List<WorkShop> findByKeyword(@Param("keyword") String keyword);
}
