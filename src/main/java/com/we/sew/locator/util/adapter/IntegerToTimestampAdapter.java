package com.we.sew.locator.util.adapter;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class IntegerToTimestampAdapter implements EntityAdapter<Timestamp, Integer> {
    @Override
    public Timestamp adapt(Integer el) {
        return null;
    }
}
