package api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RSASeverController {

	@GetMapping("getSecretMessage")
	// http://localhost:9090/getSecretMessage
	public String getMessage() {
		String message = "TheXCoders";

		EncryptionManager manager = new EncryptionManager();
		manager.initFromStrings();

		try {
			return manager.encrypt(message);

		} catch (Exception ignored) {
		}

		return null;
	}
}
