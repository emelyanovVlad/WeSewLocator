package com.we.sew.locator.db.repository;

import com.we.sew.locator.db.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, String> {
    SystemUser findOneByEmail(String email);
}
