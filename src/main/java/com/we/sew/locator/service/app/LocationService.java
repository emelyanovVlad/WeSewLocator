package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.LocationBean;
import com.we.sew.locator.db.entity.Location;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.service.app.api.ILocationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class LocationService implements ILocationService {
    @Override
    public Location getBy(String name) {
        return null;
    }

    @Override
    public List<Location> getAllBy(String name) {
        return null;
    }

    @Override
    public void create(LocationBean el, SystemUser creator) {

    }

    @Override
    public Location get(String s) {
        return null;
    }

    @Override
    public List<Location> getAll() {
        return null;
    }

    @Override
    public void update(Location el, SystemUser updater) {

    }

    @Override
    public Location delete(String el) {
        return null;
    }
}
