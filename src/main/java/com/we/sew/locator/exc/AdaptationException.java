package com.we.sew.locator.exc;

/**
 * @author Vladyslav_Yemelianov
 */
public class AdaptationException extends IllegalArgumentException {

    public AdaptationException() {
    }

    public AdaptationException(String s) {
        super(s);
    }

    public AdaptationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdaptationException(Throwable cause) {
        super(cause);
    }
}
