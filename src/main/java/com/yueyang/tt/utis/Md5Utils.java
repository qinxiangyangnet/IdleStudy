package com.yueyang.tt.utis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

    private final static char[] DIGITS =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest digest;

    private Md5Utils() {
    }

    public static String encrypt(String plaintext) throws NoSuchAlgorithmException {
        if (digest == null) {
            digest = MessageDigest.getInstance("MD5");
        }
        digest.update(plaintext.getBytes());
        byte[] cipher = digest.digest();
        char[] str = new char[32];
        int p = 0;
        for (int i = 0; i < 16; i++) {
            byte b = cipher[i];
            str[p++] = DIGITS[b >>> 4 & 0xf];
            str[p++] = DIGITS[b & 0xf];
        }
        return new String(str);
    }

}
