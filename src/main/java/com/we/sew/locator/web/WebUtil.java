package com.we.sew.locator.web;

/**
 * @author Vladyslav_Yemelianov
 */
public class WebUtil {
    public static final String REDIRECT = "redirect:";


    public static String redirectTo(String mapping) {
        return REDIRECT + mapping;
    }

    public static class Mapping {
        public static final String ADMIN = "/admin";
        public static final String HOME = "/home";
        public static final String LOGIN = "/applogin";
        public static final String LOGOUT = "/logout";
    }

    public static class View {
        public static final String ADMIN_HOME = "admin/home";
        public static final String LOGIN_FORM = "loginForm";
        public static final String LOGOUT = "logout";
    }

    private WebUtil() {}
}
