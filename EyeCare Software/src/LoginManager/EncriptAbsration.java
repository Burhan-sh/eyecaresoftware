package LoginManager;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

public class EncriptAbsration {

    private SecretKeySpec secretKey;

    public EncriptAbsration() {
    	String key = "1234567890123456";
        // Ensure the key is 16 bytes (128 bits) for AES
        byte[] keyBytes = key.getBytes();
        this.secretKey = new SecretKeySpec(keyBytes, "AES");
    }

    public String setEncryption(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String setDecryption(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
