package com.we.sew.locator.admin.db.repository;

import com.we.sew.locator.admin.db.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
