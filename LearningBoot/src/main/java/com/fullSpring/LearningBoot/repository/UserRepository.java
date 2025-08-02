package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
