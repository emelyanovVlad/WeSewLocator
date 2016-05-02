package com.we.sew.locator.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Vladyslav_Yemelianov
 */
public class AnswerBean {
    @NotBlank
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
