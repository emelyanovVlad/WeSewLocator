package com.we.sew.locator.util;

import java.util.UUID;

/**
 * @author Vladyslav_Yemelianov
 */
public class IdGeneratorUtil {

    public static String uuId() {
        return UUID.randomUUID().toString();
    }
}
