package com.we.sew.locator.util.adapter;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class DateToIntegerAdapter implements EntityAdapter<Integer, Date> {
    @Override
    public Integer adapt(Date el) {
        StringBuilder intDate = new StringBuilder();
        intDate.append(el.getYear()).append(el.getMonth()).append(el.getDay());
        return Integer.parseInt(intDate.toString());
    }
}
