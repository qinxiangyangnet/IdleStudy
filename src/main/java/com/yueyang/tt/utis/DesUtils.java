package com.yueyang.tt.utis;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;

public class DesUtils {

    private static final String DES_ALGORITHM = "DES";
    private static final String PADDING_MODE = "DES/ECB/PKCS5Padding";

    private DesUtils() {
    }

    public static String encrypt(String key, String text) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance(PADDING_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(bytes);
    }

    public static String decrypt(String key, String text) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance(PADDING_MODE);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(Base64.decodeBase64(text));
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
