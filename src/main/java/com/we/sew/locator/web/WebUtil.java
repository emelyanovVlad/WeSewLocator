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
        public static final String ROLE = "/role";
        public static final String USER = "/user";
        public static final String USERS = "/users";
        public static final String ORGANIZATION = "/organization";
        public static final String ORGANIZATIONS = "/organizations";
        public static final String LOCATIONS = "/locations";
        public static final String ORGANIZATION_LOCATION = "/orgloc";
        public static final String TYPE = "/type";

        public static final String ADD = "/add";
        public static final String DELETE = "/delete";
        public static final String FIND = "/find";
        public static final String EDIT = "/edit";
    }

    public static class View {
        public static final String ADMIN_HOME = "admin/home";
        public static final String ADMIN_ROLE = "role";
        public static final String LOGIN = "login";
        public static final String LOGOUT = "logout";
        public static final String REGISTER = "register";
        public static final String HOME = "home";
    }

    public static class ViewEntities {
        public static final String MAIN_CONTAINER = "mainContainer";
    }

    public static class Session {
        public static final String LOGGED_USER = "loggedUser";
    }

    private WebUtil() {}
}
