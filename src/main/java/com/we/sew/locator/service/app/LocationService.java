package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.LocationBean;
import com.we.sew.locator.db.entity.Location;
import com.we.sew.locator.service.app.api.ILocationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class LocationService implements ILocationService {
    @Override
    public LocationBean getBy(String name) {
        return null;
    }

    @Override
    public List<LocationBean> getAllBy(String name) {
        return null;
    }

    @Override
    public void create(LocationBean el) {

    }

    @Override
    public LocationBean get(String s) {
        return null;
    }

    @Override
    public List<LocationBean> getAll() {
        return null;
    }

    @Override
    public void update(LocationBean el) {

    }

    @Override
    public LocationBean delete(String el) {
        return null;
    }
}
