package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.SystemUserBean;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.service.app.api.ISystemUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class SystemUserService implements ISystemUserService {
    @Override
    public void create(SystemUserBean el, SystemUser creator) {

    }

    @Override
    public SystemUser get(String s) {
        return null;
    }

    @Override
    public List<SystemUser> getAll() {
        return null;
    }

    @Override
    public void update(SystemUser el, SystemUser updater) {

    }

    @Override
    public SystemUser delete(String el) {
        return null;
    }
}
