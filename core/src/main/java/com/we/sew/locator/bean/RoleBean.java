package com.we.sew.locator.bean;

import com.we.sew.locator.bean.validation.Consts;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author Vladyslav_Yemelianov
 */
public class RoleBean {

    @NotBlank
    @Pattern(regexp = Consts.CAPITALIZED_WORD)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
