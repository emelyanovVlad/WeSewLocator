package com.we.sew.locator.admin.service.api;

import com.we.sew.locator.bean.SystemUserBean;
import com.we.sew.locator.db.entity.SystemUser;

/**
 * @author Vladyslav_Yemelianov
 */
public interface ISystemUserService extends NamedEntityService<SystemUser, SystemUserBean, String> {

    SystemUser getByEmail(String email);

}