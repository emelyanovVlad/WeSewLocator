package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.bean.OrganizationBean;
import com.we.sew.locator.db.entity.Organization;
import com.we.sew.locator.admin.service.app.api.ITypeService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import com.we.sew.locator.admin.util.adapter.date.DateStringToIntegerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class OrganizationAdapter implements EntityAdapter<Organization, OrganizationBean> {

    @Autowired
    private ITypeService typeService;
    @Autowired
    private DateStringToIntegerAdapter dateStringToIntegerAdapter;

    @Override
    public Organization adapt(OrganizationBean el) {
        Organization organization = new Organization();
        organization.setDescription(el.getDescription());
        organization.setName(el.getName());
        organization.setType(typeService.getBy(el.getTypeName()));
        organization.setFoundationDate(dateStringToIntegerAdapter.adapt(el.getFoundationDate()));
        return organization;
    }
}
