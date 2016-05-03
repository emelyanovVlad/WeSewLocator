package com.we.sew.locator.admin.service;

import com.we.sew.locator.bean.OrganizationLocationBean;
import com.we.sew.locator.db.entity.OrganizationLocation;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.OrganizationLocationRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IOrganizationLocationService;
import com.we.sew.locator.admin.util.adapter.OrganizationLocationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class OrganizationLocationService extends AbstractService implements IOrganizationLocationService {

    @Autowired
    private OrganizationLocationRepository organizationLocationRepository;
    @Autowired
    private OrganizationLocationAdapter organizationLocationAdapter;

    @Override
    public void create(OrganizationLocationBean el, SystemUser creator) {
        OrganizationLocation adaptedOrganization = organizationLocationAdapter.adapt(el);
        creationUpdateInfoEntityFiller.fill(adaptedOrganization, creator);

        organizationLocationRepository.save(adaptedOrganization);
    }

    @Override
    public OrganizationLocation get(Integer id) {
        return organizationLocationRepository.getOne(id);
    }

    @Override
    public List<OrganizationLocation> getAll() {
        return organizationLocationRepository.findAll();
    }

    @Override
    public void update(OrganizationLocation el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);

        organizationLocationRepository.save(el);
    }

    @Override
    public OrganizationLocation delete(Integer id) {
        OrganizationLocation deletedOrganization = organizationLocationRepository.getOne(id);
        organizationLocationRepository.delete(id);
        return deletedOrganization;
    }
}
