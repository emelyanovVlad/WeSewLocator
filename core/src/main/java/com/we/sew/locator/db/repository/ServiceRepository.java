package com.we.sew.locator.db.repository;

import com.we.sew.locator.db.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

    Service findOneByName(String name);

    List<Service> findByNameContaining(String name);
}
