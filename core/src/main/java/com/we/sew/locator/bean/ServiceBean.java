package com.we.sew.locator.bean;

import com.we.sew.locator.bean.validation.Consts;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Vladyslav_Yemelianov
 */
public class ServiceBean {

    @NotBlank
    @Size(min = 4, max = 100, message = "Name should be between 4 and 100 symbols")
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
