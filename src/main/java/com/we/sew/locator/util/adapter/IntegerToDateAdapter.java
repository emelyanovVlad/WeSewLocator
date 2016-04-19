package com.we.sew.locator.util.adapter;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class IntegerToDateAdapter implements EntityAdapter<Date, Integer> {
    @Override
    public Date adapt(Integer el) {
        Date date = new Date();
        return null;
    }
}
