package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.bean.OrganizationFeedbackBean;
import com.we.sew.locator.db.entity.OrganizationFeedback;
import com.we.sew.locator.admin.service.api.IOrganizationService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class OrganizationFeedbackAdapter implements EntityAdapter<OrganizationFeedback, OrganizationFeedbackBean> {
    @Autowired
    private IOrganizationService organizationService;

    @Override
    public OrganizationFeedback adapt(OrganizationFeedbackBean el) {
        OrganizationFeedback organizationFeedback = new OrganizationFeedback();
        organizationFeedback.setBody(el.getBody());
        organizationFeedback.setRating(Integer.parseInt(el.getRating()));
        organizationFeedback.setOrganization(organizationService.getBy(el.getOrganizationName()));
        return organizationFeedback;
    }
}
