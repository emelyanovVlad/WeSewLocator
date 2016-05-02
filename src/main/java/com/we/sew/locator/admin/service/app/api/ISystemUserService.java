package com.we.sew.locator.admin.service.app.api;

import com.we.sew.locator.admin.bean.SystemUserBean;
import com.we.sew.locator.admin.db.entity.SystemUser;

/**
 * @author Vladyslav_Yemelianov
 */
public interface ISystemUserService extends NamedEntityService<SystemUser, SystemUserBean, String> {

    SystemUser getByEmail(String email);

}
