package com.we.sew.locator.admin.service;

import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IServiceService;
import com.we.sew.locator.admin.util.adapter.ServiceAdapter;
import com.we.sew.locator.bean.ServiceBean;
import com.we.sew.locator.db.entity.Service;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.ServiceRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@org.springframework.stereotype.Service
public class ServiceService extends AbstractService implements IServiceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceService.class);

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ServiceAdapter serviceAdapter;

    @Override
    public Service getBy(String name) {
        return serviceRepository.findOneByName(name);
    }

    @Override
    public List<Service> getAllBy(String name) {
        if (StringUtils.isBlank(name)) {
            return serviceRepository.findAll();
        }
        return serviceRepository.findByNameContaining(name);
    }

    @Override
    public void create(ServiceBean el, SystemUser creator) {
        Service adaptedService = serviceAdapter.adapt(el);
        creationUpdateInfoEntityFiller.fill(adaptedService, creator);
        serviceRepository.save(adaptedService);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(adaptedService.getName() + " created.");
        }
    }

    @Override
    public Service get(Integer serviceId) {
        return serviceRepository.getOne(serviceId);
    }

    @Override
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void update(Service el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);
        serviceRepository.save(el);

        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(el.getName() + " updated.");
        }
    }

    @Override
    public Service delete(Integer serviceId) {
        Service deletedService = get(serviceId);
        serviceRepository.delete(serviceId);

        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(deletedService.getName() + " was deleted.");
        }
        return deletedService;
    }
}
