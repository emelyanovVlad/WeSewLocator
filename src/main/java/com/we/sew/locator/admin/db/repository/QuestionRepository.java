package com.we.sew.locator.admin.db.repository;

import com.we.sew.locator.admin.db.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findOneByHeader(String name);

    List<Question> findByHeaderContaining(String name);

}
