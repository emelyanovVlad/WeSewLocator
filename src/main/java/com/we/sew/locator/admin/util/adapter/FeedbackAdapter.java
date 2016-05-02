package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.admin.bean.FeedbackBean;
import com.we.sew.locator.admin.db.entity.Feedback;
import com.we.sew.locator.admin.service.app.api.IOrganizationService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class FeedbackAdapter implements EntityAdapter<Feedback, FeedbackBean> {
    @Autowired
    private IOrganizationService organizationService;

    @Override
    public Feedback adapt(FeedbackBean el) {
        Feedback feedback = new Feedback();
        feedback.setBody(el.getBody());
        feedback.setRating(Integer.parseInt(el.getRating()));
        feedback.setOrganization(organizationService.getBy(el.getOrganizationName()));
        return feedback;
    }
}
