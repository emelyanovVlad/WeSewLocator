package com.we.sew.locator.admin.web.resp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Vladyslav_Yemelianov
 */
@ControllerAdvice
public class ControllerConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerConfig.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleExc(Exception exc) {
        LOGGER.error(exc.getMessage());
    }
}
