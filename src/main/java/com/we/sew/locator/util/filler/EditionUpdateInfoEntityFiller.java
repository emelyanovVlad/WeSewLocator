package com.we.sew.locator.util.filler;

import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.entity.UpdateInfoEntity;
import com.we.sew.locator.util.adapter.TimestampToIntegerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class EditionUpdateInfoEntityFiller implements UpdateInfoEntityFiller {
    @Autowired
    private TimestampToIntegerAdapter timestampToIntegerAdapter;
    @Override
    public void fill(UpdateInfoEntity entity, SystemUser user) {
        Timestamp curTime = new Timestamp(System.currentTimeMillis());
        entity.setUpdateTime(timestampToIntegerAdapter.adapt(curTime));
        entity.setUpdater(user);
    }
}
