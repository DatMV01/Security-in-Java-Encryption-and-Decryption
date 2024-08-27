package des.demo;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Server {
	private static final String KEY_STRING = "E0PWdbyi3Fg=";
	private static final String IV_STRING = "GqbvODK3gQc=";

	private final SecretKey key;
	private Cipher encCipher;

	public Server() throws Exception {
		this.key = generateKey();
		initCiphers();
	}

	private void initCiphers() throws Exception {
		encCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		encCipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(decoder(IV_STRING)));

		byte[] IV = encCipher.getIV();
		System.out.println("IV kEY : " + encode(IV));
	}

	public byte[] encrypt(String message) throws Exception {
		return encCipher.doFinal(message.getBytes());
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