package com.we.sew.locator.service.app.api;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
public interface GenericService<T, ID> {
    void create(T el);

    T get(ID id);

    List<T> getAll();

    void update(T el);

    T delete(ID el);

}
