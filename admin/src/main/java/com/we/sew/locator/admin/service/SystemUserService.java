package com.we.sew.locator.admin.service;

import com.we.sew.locator.admin.util.filler.CreationTimeInfoEntityFiller;
import com.we.sew.locator.admin.util.filler.EditionTimeInfoEntityFiller;
import com.we.sew.locator.bean.SystemUserBean;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.SystemUserRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.ISystemUserService;
import com.we.sew.locator.admin.util.IdGeneratorUtil;
import com.we.sew.locator.admin.util.adapter.SystemUserAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class SystemUserService implements ISystemUserService {

    @Autowired
    private CreationTimeInfoEntityFiller creationTimeInfoEntityFiller;
    @Autowired
    private EditionTimeInfoEntityFiller editionTimeInfoEntityFiller;

    @Autowired
    private SystemUserRepository systemUserRepository;
    @Autowired
    private SystemUserAdapter systemUserAdapter;

    @Override
    public void create(SystemUserBean el, SystemUser creator) {
        SystemUser adaptedUser = systemUserAdapter.adapt(el);
        adaptedUser.setId(IdGeneratorUtil.uuId());
        creationTimeInfoEntityFiller.fill(adaptedUser, creator);
        systemUserRepository.save(adaptedUser);
    }

    @Override
    public SystemUser get(String id) {
        return systemUserRepository.getOne(id);
    }

    @Override
    public List<SystemUser> getAll() {
        return systemUserRepository.findAll();
    }

    @Override
    public void update(SystemUser el, SystemUser updater) {
        editionTimeInfoEntityFiller.fill(el, updater);
        systemUserRepository.saveAndFlush(el);
    }

    @Override
    public SystemUser delete(String id) {
        SystemUser deletedUser = get(id);
        systemUserRepository.delete(id);
        return deletedUser;
    }

    @Override
    public SystemUser getBy(String name) {
        return systemUserRepository.findOneByFullName(name);
    }

    @Override
    public List<SystemUser> getAllBy(String name) {
        return systemUserRepository.findByFullNameContaining(name);
    }

    @Override
    public SystemUser getByEmail(String email) {
        return systemUserRepository.findOneByEmail(email);
    }

}
