package com.we.sew.locator.admin.util.filler;

import com.we.sew.locator.db.entity.SystemUser;

/**
 * @author Vladyslav_Yemelianov
 */
public interface EntityFiller<T> {

    void fill(T entity, SystemUser user);
}
