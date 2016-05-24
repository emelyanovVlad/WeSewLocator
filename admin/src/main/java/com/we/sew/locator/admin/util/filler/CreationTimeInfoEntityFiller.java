package com.we.sew.locator.admin.util.filler;

import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.entity.api.TimeInfoEntity;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class CreationTimeInfoEntityFiller implements EntityFiller<TimeInfoEntity>{
    @Override
    public void fill(TimeInfoEntity entity, SystemUser user) {
        long now = System.currentTimeMillis();
        entity.setCreationTime(now);
        entity.setUpdateTime(now);
    }
}
