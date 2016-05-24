package com.we.sew.locator.admin.util.filler;

import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.entity.api.UpdaterInfoEntity;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class EditionUpdaterInfoEntityFiller implements EntityFiller<UpdaterInfoEntity> {
    @Override
    public void fill(UpdaterInfoEntity entity, SystemUser user) {
        entity.setUpdateTime(System.currentTimeMillis());
        entity.setUpdater(user);
    }
}
