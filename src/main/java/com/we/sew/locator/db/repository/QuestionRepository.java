package com.we.sew.locator.db.repository;

import com.we.sew.locator.db.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
