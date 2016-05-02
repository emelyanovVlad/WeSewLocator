package com.we.sew.locator.admin.bean;

import com.we.sew.locator.admin.bean.validation.Consts;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author Vladyslav_Yemelianov
 */
public class OrganizationLocationBean {

    @NotBlank
    private String description;

    @NotBlank
    @Pattern(regexp = Consts.TEXT_WITH_NUMBERS)
    private String organizationName;

    @NotBlank
    @Pattern(regexp = Consts.TEXT_WITH_NUMBERS)
    private String locationName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
