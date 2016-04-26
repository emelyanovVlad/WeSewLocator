package com.we.sew.locator.web;

/**
 * @author Vladyslav_Yemelianov
 */
public class WebUtil {
    public static final String REDIRECT = "redirect:";

    public static String buildUrl(String... urls) {
        StringBuilder finalUrl = new StringBuilder();
        for (String url : urls) {
            finalUrl.append(url);
        }
        return finalUrl.toString();
    }

    public static String redirectTo(String mapping) {
        return REDIRECT + mapping;
    }

    public static class Mapping {
        public static final String ROOT = "/";
        public static final String ADMIN = "/admin";
        public static final String HOME = "/home";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String REGISTER = "/register";
    }

    public static class View {
        public static final String ADMIN_HOME = "admin/home";
        public static final String LOGIN = "login";
        public static final String LOGOUT = "logout";
        public static final String REGISTER = "register";
        public static final String HOME = "home";
    }

    private WebUtil() {}
}
