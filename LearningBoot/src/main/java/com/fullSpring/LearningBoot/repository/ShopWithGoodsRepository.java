package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.ShopWithGoods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopWithGoodsRepository extends JpaRepository<ShopWithGoods,String> {
}
