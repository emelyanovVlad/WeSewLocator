package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.admin.service.api.IOrganizationLocationService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import com.we.sew.locator.bean.OrganizationLocationFeedbackBean;
import com.we.sew.locator.db.entity.OrganizationLocation;
import com.we.sew.locator.db.entity.feedback.OrganizationLocationFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class OrganizationLocationFeedbackAdapter implements EntityAdapter<OrganizationLocationFeedback, OrganizationLocationFeedbackBean> {

    @Autowired
    private IOrganizationLocationService organizationLocationService;

    @Override
    public OrganizationLocationFeedback adapt(OrganizationLocationFeedbackBean el) {
        OrganizationLocationFeedback organizationLocationFeedback = new OrganizationLocationFeedback();
        OrganizationLocation organizationLocation = organizationLocationService.get(Integer.parseInt(el.getOrganizationLocationId()));
        organizationLocationFeedback.setOrganizationLocation(organizationLocation);
        organizationLocationFeedback.setBody(el.getBody());
        organizationLocationFeedback.setRating(Integer.parseInt(el.getRating()));

        return organizationLocationFeedback;
    }
}
