package com.we.sew.locator.admin.db.repository;

import com.we.sew.locator.admin.db.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type findOneByName(String name);

    List<Type> findByNameContaining(String name);

}
