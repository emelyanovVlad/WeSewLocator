package com.we.sew.locator.util.adapter.date;

import com.we.sew.locator.util.adapter.api.EntityAdapter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class IntegerToDateAdapter implements EntityAdapter<Date, Integer> {
    @Override
    public Date adapt(Integer el) {
        String dateAsString = el.toString();
        String year = dateAsString.substring(0, 4);
        String month = dateAsString.substring(5, 7);
        String day = dateAsString.substring(8, 10);
        return new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }
}
