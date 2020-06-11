package com.yueyang.tt.utis;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

public class Base64Utils {

    private Base64Utils() {
    }

    public static String encode(String text) {
        if (text == null) {
            return StringUtils.EMPTY;
        }
        return Base64.encodeBase64String(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String text) {
        if (text == null) {
            return StringUtils.EMPTY;
        }
        return new String(Base64.decodeBase64(text), StandardCharsets.UTF_8);
    }

}
