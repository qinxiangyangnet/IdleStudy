package com.yueyang.tt.utis;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.nio.charset.StandardCharsets;

public class Des3Utils {

    private static final String TRIPLE_DES_ALGORITHM = "DESede";
    private static final String PADDING_MODE = "DESede/ECB/PKCS5Padding";

    private Des3Utils() {
    }

    public static String encrypt(String key, String text) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(TRIPLE_DES_ALGORITHM);
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKey secretKey = secretKeyFactory.generateSecret(deSedeKeySpec);
        Cipher cipher = Cipher.getInstance(PADDING_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(bytes);
    }

    public static String decrypt(String key, String text) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(TRIPLE_DES_ALGORITHM);
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKey secretKey = secretKeyFactory.generateSecret(deSedeKeySpec);
        Cipher cipher = Cipher.getInstance(PADDING_MODE);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(Base64.decodeBase64(text));
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
