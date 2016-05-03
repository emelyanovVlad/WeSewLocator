package com.we.sew.locator.admin.service;

import com.we.sew.locator.bean.OrganizationBean;
import com.we.sew.locator.db.entity.Organization;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.OrganizationRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IOrganizationService;
import com.we.sew.locator.admin.util.adapter.OrganizationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class OrganizationService extends AbstractService implements IOrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private OrganizationAdapter organizationAdapter;

    @Override
    public Organization getBy(String name) {
        return organizationRepository.findOneByName(name);
    }

    @Override
    public List<Organization> getAllBy(String name) {
        return organizationRepository.findByNameContaining(name);
    }

    @Override
    public void create(OrganizationBean el, SystemUser creator) {
        Organization adaptedOrg = organizationAdapter.adapt(el);
        creationUpdateInfoEntityFiller.fill(adaptedOrg, creator);
        organizationRepository.save(adaptedOrg);
    }

    @Override
    public Organization get(Integer id) {
        return organizationRepository.findOne(id);
    }

    @Override
    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    @Override
    public void update(Organization el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);
        organizationRepository.save(el);
    }

    @Override
    public Organization delete(Integer id) {
        Organization deletedOrganization = get(id);
        organizationRepository.delete(id);
        return deletedOrganization;
    }
}
