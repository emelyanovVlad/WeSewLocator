package com.we.sew.locator.admin.util.adapter.date;

import com.we.sew.locator.admin.exc.AdaptationException;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class DateStringToIntegerAdapter implements EntityAdapter<Integer, String> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private DateToIntegerAdapter dateToIntegerAdapter;

    @Override
    public Integer adapt(String dateString) {
        try {
            return dateToIntegerAdapter.adapt(dateFormat.parse(dateString));
        } catch (ParseException e) {
            throw new AdaptationException(dateString + " cannot be adapted to date.");
        }
    }
}
