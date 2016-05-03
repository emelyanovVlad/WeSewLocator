package com.we.sew.locator.bean;

import com.we.sew.locator.bean.validation.Consts;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author Vladyslav_Yemelianov
 */
public class OrganizationBean {

    @NotBlank
    @Pattern(regexp = Consts.CHARACTER_TEXT)
    private String categoryName;

    @NotBlank
    @Pattern(regexp = Consts.TEXT_WITH_NUMBERS)
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    @Pattern(regexp = Consts.DATE_PATTERN)
    private String foundationDate;

    public String getTypeName() {
        return categoryName;
    }

    public void setTypeName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }
}
