package com.we.sew.locator.util.filler;

import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.entity.UpdateInfoEntity;
import com.we.sew.locator.util.adapter.date.TimestampToIntegerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class CreationUpdateInfoEntityFiller implements UpdateInfoEntityFiller {
    @Autowired
    private TimestampToIntegerAdapter timestampToIntegerAdapter;

    @Override
    public void fill(UpdateInfoEntity entity, SystemUser user) {
        Timestamp curTime = new Timestamp(System.currentTimeMillis());
        Integer adaptedTimestamp = timestampToIntegerAdapter.adapt(curTime);
        entity.setCreationTime(adaptedTimestamp);
        entity.setUpdateTime(adaptedTimestamp);
        entity.setCreator(user);
        entity.setUpdater(user);
    }
}
