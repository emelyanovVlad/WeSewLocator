package com.we.sew.locator.admin.service.app.api;

import com.we.sew.locator.admin.db.entity.SystemUser;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
public interface GenericService<BEAN, DTO, ID> {
    void create(DTO el, SystemUser creator);

    BEAN get(ID id);

    List<BEAN> getAll();

    void update(BEAN el, SystemUser updater);

    BEAN delete(ID el);

}
