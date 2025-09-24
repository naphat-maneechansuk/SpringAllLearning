package com.fullSpring.LearningBoot.repository;

import com.fullSpring.LearningBoot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Long, Book> {

}