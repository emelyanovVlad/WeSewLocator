package com.we.sew.locator.admin.util.adapter.date;

import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class IntegerToDateAdapter implements EntityAdapter<Date, Long> {
    @Override
    public Date adapt(Long time) {
        return new Date(time);
    }
}
