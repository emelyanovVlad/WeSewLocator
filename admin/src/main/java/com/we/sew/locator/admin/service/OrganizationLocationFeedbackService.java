package com.we.sew.locator.admin.service;

import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IOrganizationLocationFeedbackService;
import com.we.sew.locator.admin.util.IdGeneratorUtil;
import com.we.sew.locator.admin.util.adapter.OrganizationLocationFeedbackAdapter;
import com.we.sew.locator.bean.OrganizationLocationFeedbackBean;
import com.we.sew.locator.db.entity.feedback.OrganizationLocationFeedback;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.OrganizationLocationFeedbackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class OrganizationLocationFeedbackService extends AbstractService implements IOrganizationLocationFeedbackService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationLocationFeedbackService.class);

    @Autowired
    private OrganizationLocationFeedbackRepository repository;
    @Autowired
    private OrganizationLocationFeedbackAdapter adapter;

    @Override
    public void create(OrganizationLocationFeedbackBean el, SystemUser creator) {
        OrganizationLocationFeedback adaptedFeedback = adapter.adapt(el);
        creationUpdaterInfoEntityFiller.fill(adaptedFeedback, creator);
        adaptedFeedback.setId(IdGeneratorUtil.uuId());
        repository.save(adaptedFeedback);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("'{}' added to '{}' organization location", adaptedFeedback.getBody(), adaptedFeedback.getOrganizationLocation().getId());
        }
    }

    @Override
    public OrganizationLocationFeedback get(String id) {
        return repository.getOne(id);
    }

    @Override
    public List<OrganizationLocationFeedback> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(OrganizationLocationFeedback el, SystemUser updater) {
        editionUpdaterInfoEntityFiller.fill(el, updater);

        LOGGER.debug("{} updated", el.getId());
    }

    @Override
    public OrganizationLocationFeedback delete(String id) {
        OrganizationLocationFeedback deletedFeedback = get(id);
        LOGGER.warn("{} was deleted", deletedFeedback.getBody());
        return deletedFeedback;
    }
}
