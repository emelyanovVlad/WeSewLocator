package com.we.sew.locator.admin.util.adapter.date;

import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class TimestampToIntegerAdapter implements EntityAdapter<Integer, Timestamp> {
    @Override
    public Integer adapt(Timestamp el) {
        StringBuilder intDate = new StringBuilder();
        intDate.append(el.getYear())
                .append(el.getMonth())
                .append(el.getDay())
                .append(el.getHours())
                .append(el.getMinutes())
                .append(el.getSeconds());
        return Integer.parseInt(intDate.toString());
    }
}
