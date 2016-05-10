package com.we.sew.locator.admin.util.adapter.date;

import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class IntegerToTimestampAdapter implements EntityAdapter<Timestamp, Integer> {
    @Override
    public Timestamp adapt(Integer el) {
        String timeAsString = el.toString();
        String year = timeAsString.substring(0, 4);
        String month = timeAsString.substring(5, 7);
        String day = timeAsString.substring(8, 10);
        String hour = timeAsString.substring(11, 13);
        String minute = timeAsString.substring(14, 16);
        String seconds = timeAsString.substring(17, 19);
        return new Timestamp(Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(day),
                Integer.parseInt(hour),
                Integer.parseInt(minute),
                Integer.parseInt(seconds), 0);
    }
}
