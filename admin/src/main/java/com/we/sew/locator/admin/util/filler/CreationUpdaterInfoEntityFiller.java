package com.we.sew.locator.admin.util.filler;

import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.entity.UpdaterInfoEntity;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class CreationUpdaterInfoEntityFiller implements EntityFiller<UpdaterInfoEntity> {

    @Override
    public void fill(UpdaterInfoEntity entity, SystemUser user) {
        Long currentTimestamp = System.currentTimeMillis();
        entity.setCreationTime(currentTimestamp);
        entity.setUpdateTime(currentTimestamp);
        entity.setCreator(user);
        entity.setUpdater(user);
    }
}
