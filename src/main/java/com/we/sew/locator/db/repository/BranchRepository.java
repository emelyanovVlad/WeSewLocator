package com.we.sew.locator.db.repository;

import com.we.sew.locator.db.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    Branch findOneByName(String name);

    List<Branch> findByNameContaining(String name);
}
