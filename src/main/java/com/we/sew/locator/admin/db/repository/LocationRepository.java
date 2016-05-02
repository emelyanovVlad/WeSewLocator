package com.we.sew.locator.admin.db.repository;

import com.we.sew.locator.admin.db.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    Location findOneByName(String name);

    List<Location> findByNameContaining(String name);
}
