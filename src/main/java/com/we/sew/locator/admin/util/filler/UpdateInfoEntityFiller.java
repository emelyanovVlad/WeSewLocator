package com.we.sew.locator.admin.util.filler;

import com.we.sew.locator.admin.db.entity.SystemUser;
import com.we.sew.locator.admin.db.entity.UpdateInfoEntity;

/**
 * @author Vladyslav_Yemelianov
 */
public interface UpdateInfoEntityFiller {

    void fill(UpdateInfoEntity entity, SystemUser user);
}
