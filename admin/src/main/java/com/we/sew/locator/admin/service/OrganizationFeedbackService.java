package com.we.sew.locator.admin.service;

import com.we.sew.locator.bean.OrganizationFeedbackBean;
import com.we.sew.locator.db.entity.OrganizationFeedback;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.OrganizationFeedbackRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IOrganizationFeedbackService;
import com.we.sew.locator.admin.util.IdGeneratorUtil;
import com.we.sew.locator.admin.util.adapter.FeedbackAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class OrganizationFeedbackService extends AbstractService implements IOrganizationFeedbackService {
    @Autowired
    private OrganizationFeedbackRepository organizationFeedbackRepository;
    @Autowired
    private FeedbackAdapter feedbackAdapter;

    @Override
    public void create(OrganizationFeedbackBean el, SystemUser creator) {
        OrganizationFeedback adaptedFeed = feedbackAdapter.adapt(el);
        adaptedFeed.setId(IdGeneratorUtil.uuId());
        creationUpdaterInfoEntityFiller.fill(adaptedFeed, creator);
    }

    @Override
    public OrganizationFeedback get(String id) {
        return organizationFeedbackRepository.getOne(id);
    }

    @Override
    public List<OrganizationFeedback> getAll() {
        return organizationFeedbackRepository.findAll();
    }

    @Override
    public void update(OrganizationFeedback el, SystemUser updater) {
        editionUpdaterInfoEntityFiller.fill(el, updater);
        organizationFeedbackRepository.saveAndFlush(el);
    }

    @Override
    public OrganizationFeedback delete(String id) {
        OrganizationFeedback deletedOrganizationFeedback = get(id);
        organizationFeedbackRepository.delete(id);
        return deletedOrganizationFeedback;
    }
}
