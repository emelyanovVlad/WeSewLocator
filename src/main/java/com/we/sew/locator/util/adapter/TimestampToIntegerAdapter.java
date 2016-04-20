package com.we.sew.locator.util.adapter;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class TimestampToIntegerAdapter implements EntityAdapter<Integer, Timestamp> {
    @Override
    public Integer adapt(Timestamp el) {
        return null;
    }
}
