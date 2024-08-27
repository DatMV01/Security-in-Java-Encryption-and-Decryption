package des.demo;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import algo.DES;

import java.util.Base64;

public class Client {
	private final SecretKey key;

	private static final String KEY_STRING = "E0PWdbyi3Fg=";
	private static final String IV_STRING = "GqbvODK3gQc=";

	private Cipher decCipher;

	public Client() throws Exception {
		this.key = generateKey();
		initCiphers();
	}

	private void initCiphers() throws Exception {
		decCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		decCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(decoder(IV_STRING)));

	}

	public String decryt(byte[] messsage) throws Exception {
		return new String(decCipher.doFinal(messsage));
	}

	public static SecretKey generateKey() throws Exception {
		return new SecretKeySpec(decoder(KEY_STRING), "DES");
	}

	public static String encode(byte[] data) {
		return Base64.getEncoder().encodeToString(data);
	}

	public static byte[] decoder(String data) {
		return Base64.getDecoder().decode(data);
	}

}