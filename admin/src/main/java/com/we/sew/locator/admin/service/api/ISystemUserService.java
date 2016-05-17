package com.we.sew.locator.admin.service.api;

import com.we.sew.locator.bean.AdminSystemUserBean;
import com.we.sew.locator.db.entity.SystemUser;

/**
 * @author Vladyslav_Yemelianov
 */
public interface ISystemUserService extends NamedEntityService<SystemUser, AdminSystemUserBean, String> {

    SystemUser getByEmail(String email);

}
