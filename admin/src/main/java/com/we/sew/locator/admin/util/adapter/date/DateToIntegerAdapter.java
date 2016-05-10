package com.we.sew.locator.admin.util.adapter.date;

import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class DateToIntegerAdapter implements EntityAdapter<Long, Date> {
    @Override
    public Long adapt(Date date) {
        return date.getTime();
    }
}
