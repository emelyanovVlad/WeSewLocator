package com.we.sew.locator.admin.util.adapter.date;

import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class TimestampToIntegerAdapter implements EntityAdapter<Long, Timestamp> {
    @Override
    public Long adapt(Timestamp el) {
        return el.getTime();
    }
}
