package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.OrderGoodsPk;
import com.fullSpring.LearningBoot.entity.OrderGoodsWithFk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderGoodsWithFkRepository extends JpaRepository<OrderGoodsWithFk, OrderGoodsPk> {
}
