package com.we.sew.locator.db;

/**
 * @author Vladyslav_Yemelianov
 */
public class Db {
    public static class UpdateInfo {
        public static final String CREATE_TIME = "create_time";
        public static final String CREATOR_ID = "id_creator";
        public static final String UPDATE_TIME = "update_time";
        public static final String UPDATER_ID = "id_updater";
    }

    public static class Type {
        public static final String TABLE_NAME = "type";
        public static final String ID = "id_type";
        public static final String NAME = "name";
    }

    public static class Question {
        public static final String TABLE_NAME = "question";
        public static final String ID = "id_question";
        public static final String HEADER = "header";
        public static final String BODY = "body";
        public static final String TYPE_ID = "id_type";
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
}
