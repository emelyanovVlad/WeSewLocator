package com.we.sew.locator.admin.util.adapter.date;

import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class IntegerToTimestampAdapter implements EntityAdapter<Timestamp, Long> {
    @Override
    public Timestamp adapt(Long time) {
        return new Timestamp(time);
    }
}
