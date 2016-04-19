package com.we.sew.locator.db.repository;

import com.we.sew.locator.db.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
