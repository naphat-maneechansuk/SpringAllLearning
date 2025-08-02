package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,String> {
     List<Goods> findByShopShopId(String shopId);

     @Query("SELECT g FROM Goods g WHERE g.shop.shopId = :shopId ")
     List<Goods> findByShopIdJpql(@Param("shopId") String shopId);
}
