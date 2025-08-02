package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.OrderGoodsNoFk;
import com.fullSpring.LearningBoot.entity.OrderGoodsPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderGoodsNoFkRepository extends JpaRepository<OrderGoodsNoFk, OrderGoodsPk> {

}
