package com.we.sew.locator.db.repository;

import com.we.sew.locator.db.entity.feedback.OrganizationLocationFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface OrganizationLocationFeedbackRepository extends JpaRepository<OrganizationLocationFeedback, String> {
}
