package com.we.sew.locator.admin.util.adapter.api;

/**
 * @author Vladyslav_Yemelianov
 */
public interface EntityAdapter<R, T> {

    R adapt(T el);
}
