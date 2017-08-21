package org.lucius.commons.utils.encrypt;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;

public class AESUtils {

	private static final String AES_ALGORITHM = "AES";

	public static String encrypt(String content, String encryptKey) {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance(AES_ALGORITHM);
			keygen.init(128, new SecureRandom(encryptKey.getBytes(StandardCharsets.UTF_8)));
			SecretKey originalKey = keygen.generateKey();
			byte[] raw = originalKey.getEncoded();
			SecretKey key = new SecretKeySpec(raw, AES_ALGORITHM);
			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
			byte[] result = cipher.doFinal(byteContent);
			String base64String = Base64Utils.encodeToString(result);
			return base64String;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decrypt(String content, String encryptKey) {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			keygen.init(128, new SecureRandom(encryptKey.getBytes(StandardCharsets.UTF_8)));
			SecretKey originalKey = keygen.generateKey();
			byte[] raw = originalKey.getEncoded();
			SecretKey key = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] byteContent = Base64Utils.decodeFromString(content);
			byte[] result = cipher.doFinal(byteContent);
			return new String(result, StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
