package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods,String> {

}
