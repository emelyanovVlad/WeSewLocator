package com.we.sew.locator.admin.util;

import java.util.UUID;

/**
 * @author Vladyslav_Yemelianov
 */
public class IdGeneratorUtil {

    public static String uuId() {
        return UUID.randomUUID().toString();
    }
}
