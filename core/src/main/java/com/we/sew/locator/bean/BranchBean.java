package com.we.sew.locator.bean;

import com.we.sew.locator.bean.validation.Consts;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Vladyslav_Yemelianov
 */
public class BranchBean {

    @NotBlank
    @Size(min = 5, max = 100, message = "Must be between 5 and 100 symbols length")
    private String name;

    @NotBlank
    @Pattern(regexp = Consts.CHARACTER_TEXT)
    private String categoryName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return categoryName;
    }

    public void setTypeName(String categoryName) {
        this.categoryName = categoryName;
    }
}
