package com.we.sew.locator.util.adapter;

import com.we.sew.locator.bean.SystemUserBean;
import com.we.sew.locator.db.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class SystemUserAdapter implements EntityAdapter<SystemUser, SystemUserBean>{

    @Autowired
    private DateStringToIntegerAdapter dateStringToIntegerAdapter;

    @Override
    public SystemUser adapt(SystemUserBean el) {
        SystemUser systemUser = new SystemUser();
        systemUser.setEmail(el.getEmail());
        Integer adaptedBirthDate = dateStringToIntegerAdapter.adapt(el.getBirthDate());
        systemUser.setBirthDate(adaptedBirthDate);
        systemUser.setFullName(el.getFullName());
        systemUser.setPassword(DigestUtils.md5DigestAsHex(el.getPassword().getBytes()));
        return systemUser;
    }
}
