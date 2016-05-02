package com.we.sew.locator.admin.exc;

/**
 * @author Vladyslav_Yemelianov
 */
public class DataManipulationException extends IllegalArgumentException {

    public DataManipulationException() {
    }

    public DataManipulationException(String s) {
        super(s);
    }

    public DataManipulationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataManipulationException(Throwable cause) {
        super(cause);
    }
}
