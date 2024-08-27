package des.demo;

import java.util.Base64;

import javax.crypto.SecretKey;

import algo.DES;

public class Main {
	public static String encode(byte[] data) {
		return Base64.getEncoder().encodeToString(data);
	}

	public static byte[] decoder(String data) {
		return Base64.getDecoder().decode(data);
	}

	public static void main(String[] args) throws Exception {

		String message = "The X Coders";

		Server des = new Server();
		String encryptedMessage = encode(des.encrypt(message));
		System.out.println("Encrypted Message: " + encryptedMessage);

		Client client = new Client();
		System.out.println("Decrypted Message: " + client.decryt(decoder(encryptedMessage)));

	}
}
