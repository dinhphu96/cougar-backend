package com.cougar.security;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
	private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    // Hàm mã hóa dữ liệu bằng AES
    public static String encryptData(String data, String key, String iv) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Hàm giải mã dữ liệu bằng AES
    public static String decryptData(String ciphertext, String key, String iv) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decoded = Base64.getDecoder().decode(ciphertext);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted, "UTF-8");
    }
}
