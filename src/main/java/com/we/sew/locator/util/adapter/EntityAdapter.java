package com.we.sew.locator.util.adapter;

/**
 * @author Vladyslav_Yemelianov
 */
public interface EntityAdapter<R, T> {

    R adapt(T el);
}
