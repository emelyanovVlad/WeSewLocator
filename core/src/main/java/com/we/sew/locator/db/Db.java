package com.we.sew.locator.db;

/**
 * @author Vladyslav_Yemelianov
 */
public class Db {
    public static class UpdateInfo {
        public static final String CREATE_TIME = "create_time";
        public static final String CREATOR_ID = "id_user_creator";
        public static final String UPDATE_TIME = "update_time";
        public static final String UPDATER_ID = "id_user_updater";
    }

    public static class Category {
        public static final String TABLE_NAME = "category";
        public static final String ID = "id_category";
        public static final String NAME = "name_value";
    }

    public static class Question {
        public static final String TABLE_NAME = "question";
        public static final String ID = "id_question";
        public static final String HEADER = "header";
        public static final String BODY = "body";
        public static final String CATEGORY_ID = "id_category";
    }

    public static class Answer {
        public static final String TABLE_NAME = "answer";
        public static final String ID = "id_answer";
        public static final String BODY = "body";
    }

    public static class QuestionAnswer {
        public static final String TABLE_NAME = "question_answer";
        public static final String ID = "id_question_answer";
        public static final String QUESTION_ID = "id_question";
        public static final String ANSWER_ID = "id_answer";
        public static final String NEXT_QUESTION_ID = "id_next_question";
    }

    public static class Branch {
        public static final String TABLE_NAME = "branch";
        public static final String ID = "id_branch";
        public static final String NAME = "name_value";
        public static final String CATEGORY_ID = "id_category";
    }

    public static class BranchQuestion {
        public static final String TABLE_NAME = "branch_question";
        public static final String ID = "id_branch_question";
        public static final String BRANCH_ID = "id_branch";
        public static final String QUESTION_ID = "id_question";
        public static final String FIRST = "first";
    }

    public static class Location {
        public static final String TABLE_NAME = "location";
        public static final String ID = "id_location";
        public static final String NAME = "name_value";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
    }

    public static class Organization {
        public static final String TABLE_NAME = "organization";
        public static final String ID = "id_organization";
        public static final String NAME = "name_value";
        public static final String CATEGORY_ID = "id_category";
        public static final String DESCRIPTION = "description";
        public static final String FOUNDED = "foundation_date";
    }

    public static class OrganizationLocation {
        public static final String TABLE_NAME = "organization_location";
        public static final String ID = "id_org_loc";
        public static final String DESCRIPTION = "description";
        public static final String LOCATION_ID = "id_location";
        public static final String ORGANIZATION_ID = "id_organization";
    }
    
    public static class OrganizationFeedback {
        public static final String TABLE_NAME = "org_feedback";
        public static final String ID = "id_org_feedback";
        public static final String BODY = "body";
        public static final String RATING = "rating";
        public static final String POSTER_ID = "id_user";
        public static final String ORGANIZATION_ID = "id_organization";
    }

    public static class OrganizationLocationFeedback {
        public static final String TABLE_NAME = "org_loc_feedback";
        public static final String ID = "id_org_loc_feedback";
        public static final String BODY = "body";
        public static final String RATING = "rating";
        public static final String POSTER_ID = "id_user";
        public static final String ORGANIZATION_LOCATION_ID = "id_org_loc";
    }

    public static class SystemUser {
        public static final String TABLE_NAME = "system_user";
        public static final String ID = "id_user";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String FULL_NAME = "full_name";
        public static final String BIRTH_DATE = "birth_date";
        public static final String LAST_LOGIN = "last_login";
        public static final String ROLE_ID = "id_role";
    }

    public static class Role {
        public static final String TABLE_NAME = "role";
        public static final String ID = "id_role";
        public static final String NAME = "name_value";
    }

    public static class Service {
        public static final String TABLE_NAME = "service";
        public static final String ID = "id_service";
        public static final String NAME = "name_value";
        public static final String CATEGORY_ID = "id_category";
    }

    public static class ServiceOrganization {
        public static final String TABLE_NAME = "service_organization";
        public static final String SERVICE_ID = "id_service";
        public static final String ORG_ID = "id_organization";
    }

    private Db(){}
}
