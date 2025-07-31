package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepositoy extends JpaRepository<Shop , String> {
    List<Shop> findByShopName(String shopName);
    List<Shop> findByShopNameNotLike(String shopName);

    @Query("SELECT s FROM Shop AS s WHERE s.shopName = :inputString ")
    List<Shop> findByJpqlShopName(@Param("inputString") String inputShopName);

}
