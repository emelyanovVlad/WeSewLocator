package com.we.sew.locator.service.app.api;


import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
public interface NamedEntityService<BEAN,DTO, ID> extends GenericService<BEAN, DTO,  ID> {
    BEAN getBy(String name);

    List<BEAN> getAllBy(String name);
}
