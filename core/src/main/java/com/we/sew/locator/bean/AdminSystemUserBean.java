package com.we.sew.locator.bean;

import com.we.sew.locator.bean.validation.Consts;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author Vladyslav_Yemelianov
 */
public class AdminSystemUserBean extends SystemUserBean {

    @NotBlank
    @Pattern(regexp = Consts.CAPITALIZED_WORD)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
