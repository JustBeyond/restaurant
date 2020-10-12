package com.furseal.restaurant.common.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AesEncryptUtil {
    private static final String secretKeyOrSalt = "RAINBOW_ZONE";

    public static String encryptWithHEX(String inputText) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(secretKeyOrSalt.getBytes());
            keyGenerator.init(128, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormatSecretKey = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormatSecretKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(inputText.getBytes("utf-8"));
            StringBuilder buf = new StringBuilder(result.length * 2);
            for (byte b : result) {
                buf.append(String.format("%02x", new Integer(b & 0xff)));
            }
            return buf.toString().toUpperCase();
        } catch (Exception e) {
            return inputText;
        }
    }

    public static String encryptWithHEX(String inputText, String secretKeyOrSalt) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(secretKeyOrSalt.getBytes());
            keyGenerator.init(128, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormatSecretKey = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormatSecretKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(inputText.getBytes("utf-8"));
            StringBuilder buf = new StringBuilder(result.length * 2);
            for (byte b : result) {
                buf.append(String.format("%02x", new Integer(b & 0xff)));
            }
            return buf.toString().toUpperCase();
        } catch (Exception e) {
            return inputText;
        }
    }


    public static String decryptWithHEX(String cipherText) {
        try {
            cipherText = cipherText.toLowerCase();
            byte[] bytes = new byte[cipherText.length() / 2];
            for (int i = 0; i < cipherText.length() / 2; i++) {
                String subStr = cipherText.substring(i * 2, i * 2 + 2);
                bytes[i] = (byte) Integer.parseInt(subStr, 16);
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            byte[] aesCipherData = bytes;
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(secretKeyOrSalt.getBytes());
            keyGenerator.init(128, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormatSecretKey = secretKey.getEncoded();
            SecretKeySpec aesSecretKey = new SecretKeySpec(enCodeFormatSecretKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesSecretKey);
            byte[] aesUncryptData = cipher.doFinal(aesCipherData);
            return new String(aesUncryptData, "utf-8");
        } catch (Exception e) {
            return cipherText;
        }
    }

    public static String decryptWithHEX(String cipherText, String secretKeyOrSalt) {
        try {
            cipherText = cipherText.toLowerCase();
            byte[] bytes = new byte[cipherText.length() / 2];
            for (int i = 0; i < cipherText.length() / 2; i++) {
                String subStr = cipherText.substring(i * 2, i * 2 + 2);
                bytes[i] = (byte) Integer.parseInt(subStr, 16);
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            byte[] aesCipherData = bytes;
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(secretKeyOrSalt.getBytes());
            keyGenerator.init(128, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormatSecretKey = secretKey.getEncoded();
            SecretKeySpec aesSecretKey = new SecretKeySpec(enCodeFormatSecretKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesSecretKey);
            byte[] aesUncryptData = cipher.doFinal(aesCipherData);
            return new String(aesUncryptData, "utf-8");
        } catch (Exception e) {
            return cipherText;
        }
    }

    public static void main(String[] args) {
        String root = encryptWithHEX("jdbc:mysql://47.105.41.241:3306/rainbow");
        System.out.println(root);
    }
}
