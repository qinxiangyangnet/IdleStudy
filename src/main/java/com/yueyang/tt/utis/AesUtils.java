package com.yueyang.tt.utis;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AesUtils {

    private static final String AES_ALGORITHM = "AES";
    private static final String PADDING_MODE = "AES/ECB/PKCS5Padding";

    private AesUtils() {
    }

    public static String encrypt(String key, String text) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(PADDING_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] bytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(bytes);
    }

    public static String decrypt(String key, String text) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(PADDING_MODE);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] bytes = cipher.doFinal(Base64.decodeBase64(text));
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
