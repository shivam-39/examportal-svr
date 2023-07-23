package com.nash.examportal.repository;

import com.nash.examportal.model.Category;
import com.nash.examportal.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    public List<Quiz> findByCategory(Category category);

    public List<Quiz> findByActive(Boolean active);

    public List<Quiz> findByCategoryAndActive(Category category, Boolean active);
}
