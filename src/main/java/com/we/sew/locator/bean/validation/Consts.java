package com.we.sew.locator.bean.validation;

/**
 * @author Vladyslav_Yemelianov
 */
public class Consts {
    public static final String DATE_PATTERN = "\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])";
    public static final String CHARACTER_TEXT = "[A-Za-z\\s]+";
    public static final String TEXT_WITH_NUMBERS = "[A-Za-z0-9\\s]+";
    public static final String CAPITALIZED_WORD = "[A-Za-z]+";

    private Consts(){}
}
