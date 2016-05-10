package com.we.sew.locator.admin.util.filler;

import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.entity.UpdateInfoEntity;
import com.we.sew.locator.admin.util.adapter.date.TimestampToIntegerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class CreationUpdateInfoEntityFiller implements UpdateInfoEntityFiller {

    @Override
    public void fill(UpdateInfoEntity entity, SystemUser user) {
        Long currentTimestamp = System.currentTimeMillis();
        entity.setCreationTime(currentTimestamp);
        entity.setUpdateTime(currentTimestamp);
        entity.setCreator(user);
        entity.setUpdater(user);
    }
}
