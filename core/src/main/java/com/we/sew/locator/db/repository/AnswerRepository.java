package com.we.sew.locator.db.repository;

import com.we.sew.locator.db.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
