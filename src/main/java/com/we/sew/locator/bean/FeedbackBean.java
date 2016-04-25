package com.we.sew.locator.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;


/**
 * @author Vladyslav_Yemelianov
 */
public class FeedbackBean {

    @NotBlank
    private String organizationName;

    @NotBlank
    private String body;

    @NotBlank
    @Range(min = 0, max = 5, message = "Rating between 0 and 5")
    private String rating;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
