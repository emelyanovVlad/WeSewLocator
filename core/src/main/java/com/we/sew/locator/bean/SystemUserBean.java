package com.we.sew.locator.bean;

import com.we.sew.locator.bean.validation.Consts;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;


/**
 * @author Vladyslav_Yemelianov
 */
public class SystemUserBean {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9\\.]{4,50}")
    private String password;

    @NotBlank
    @Pattern(regexp = "([A-Z][a-z]+\\s?)+")
    private String fullName;

    @NotBlank
    @Pattern(regexp = Consts.DATE_PATTERN)
    private String birthDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
