package com.yueyang.tt.utis;

import java.util.UUID;

public class StrUtils {

    private StrUtils() {
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
