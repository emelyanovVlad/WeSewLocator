package com.we.sew.locator.admin.service;

import com.we.sew.locator.bean.LocationBean;
import com.we.sew.locator.db.entity.Location;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.LocationRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.ILocationService;
import com.we.sew.locator.admin.util.IdGeneratorUtil;
import com.we.sew.locator.admin.util.adapter.LocationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class LocationService extends AbstractService implements ILocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationAdapter locationAdapter;

    @Override
    public Location getBy(String name) {
        return locationRepository.findOneByName(name);
    }

    @Override
    public List<Location> getAllBy(String name) {
        return locationRepository.findByNameContaining(name);
    }

    @Override
    public void create(LocationBean el, SystemUser creator) {
        Location adaptedLocation = locationAdapter.adapt(el);
        adaptedLocation.setId(IdGeneratorUtil.uuId());
        creationUpdateInfoEntityFiller.fill(adaptedLocation, creator);
        locationRepository.save(adaptedLocation);
    }

    @Override
    public Location get(String id) {
        return locationRepository.getOne(id);
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public void update(Location el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);
        locationRepository.saveAndFlush(el);
    }

    @Override
    public Location delete(String id) {
        Location deletedLocation = get(id);
        locationRepository.delete(id);
        return deletedLocation;
    }
}
