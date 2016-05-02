package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.bean.OrganizationLocationBean;
import com.we.sew.locator.db.entity.OrganizationLocation;
import com.we.sew.locator.admin.service.app.api.ILocationService;
import com.we.sew.locator.admin.service.app.api.IOrganizationService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class OrganizationLocationAdapter implements EntityAdapter<OrganizationLocation, OrganizationLocationBean> {

    @Autowired
    private ILocationService locationService;
    @Autowired
    private IOrganizationService organizationService;

    @Override
    public OrganizationLocation adapt(OrganizationLocationBean el) {
        OrganizationLocation organizationLocation = new OrganizationLocation();
        organizationLocation.setLocation(locationService.getBy(el.getLocationName()));
        organizationLocation.setOrganization(organizationService.getBy(el.getOrganizationName()));
        organizationLocation.setDesc(el.getDescription());
        return organizationLocation;
    }
}
