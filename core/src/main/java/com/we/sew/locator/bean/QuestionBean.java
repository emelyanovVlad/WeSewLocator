package com.we.sew.locator.bean;

import com.we.sew.locator.bean.validation.Consts;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;


/**
 * @author Vladyslav_Yemelianov
 */
public class QuestionBean {

    @NotBlank
    @Pattern(regexp = Consts.CHARACTER_TEXT)
    private String header;

    @NotBlank
    private String body;

    @NotBlank
    @Pattern(regexp = Consts.CHARACTER_TEXT)
    private String categoryName;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTypeName() {
        return categoryName;
    }

    public void setTypeName(String categoryName) {
        this.categoryName = categoryName;
    }
}
