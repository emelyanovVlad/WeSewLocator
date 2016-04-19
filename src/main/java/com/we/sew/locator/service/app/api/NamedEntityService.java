package com.we.sew.locator.service.app.api;


import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
public interface NamedEntityService<T, ID> extends GenericService<T, ID> {
    T getBy(String name);

    List<T> getAllBy(String name);
}
