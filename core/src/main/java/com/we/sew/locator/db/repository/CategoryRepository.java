package com.we.sew.locator.db.repository;

import com.we.sew.locator.db.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findOneByName(String name);

    List<Category> findByNameContaining(String name);

}
