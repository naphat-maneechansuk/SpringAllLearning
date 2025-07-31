package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepositoy extends JpaRepository<Shop , String> {
    List<Shop> findByShopName(String shopName);
    List<Shop> findByShopNameNotLike(String shopName);


}
