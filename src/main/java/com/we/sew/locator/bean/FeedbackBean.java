package com.we.sew.locator.bean;

/**
 * @author Vladyslav_Yemelianov
 */
public class FeedbackBean {

    private String organizationName;

    private String body;

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
