package com.we.sew.locator.util.filler;

import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.entity.UpdateInfoEntity;

/**
 * @author Vladyslav_Yemelianov
 */
public interface UpdateInfoEntityFiller {

    void fill(UpdateInfoEntity entity, SystemUser user);
}
