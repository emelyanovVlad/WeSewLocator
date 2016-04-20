package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.OrganizationBean;
import com.we.sew.locator.db.entity.Organization;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.service.app.api.IOrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class OrganizationService implements IOrganizationService {
    @Override
    public Organization getBy(String name) {
        return null;
    }

    @Override
    public List<Organization> getAllBy(String name) {
        return null;
    }

    @Override
    public void create(OrganizationBean el, SystemUser creator) {

    }

    @Override
    public Organization get(Integer integer) {
        return null;
    }

    @Override
    public List<Organization> getAll() {
        return null;
    }

    @Override
    public void update(Organization el, SystemUser updater) {

    }

    @Override
    public Organization delete(Integer el) {
        return null;
    }
}
