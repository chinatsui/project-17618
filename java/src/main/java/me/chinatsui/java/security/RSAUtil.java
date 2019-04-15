package me.chinatsui.java.security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.stream.Stream;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAUtil {

    /**
     * Read data.
     */
    public static byte[] readData(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            StringBuilder sb = new StringBuilder();
            lines.filter(line -> !line.startsWith("---")).forEach(sb::append);
            return sb.toString().getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generate public key, the input public key file must be pkcs8 format.
     */
    public static PublicKey getPublicKey(Path path) {
        // 1. Read Base64 encoded public key data.
        byte[] base64Data = readData(path);

        // 2. Base64 decoding
        byte[] keyData = Base64.getDecoder().decode(base64Data);

        // 3. Generate public key
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyData);
            return KeyFactory.getInstance("RSA").generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generate private key, the input private key file must be pkcs8 format.
     */
    public static PrivateKey getPrivateKey(Path path) {
        // 1. Read Base64 encoded public key data.
        byte[] based64Data = readData(path);

        // 2. Base64 decoding
        byte[] keyData = Base64.getDecoder().decode(based64Data);

        // 3. Generate private key
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyData);
            return KeyFactory.getInstance("RSA").generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Encrypt data with public key
     */
    public static String encryptData(PublicKey publicKey, String data) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytesEncrypt = cipher.doFinal(data.getBytes());

            // Base64 encoding
            byte[] bytesEncryptBase64 = Base64.getEncoder().encode(bytesEncrypt);
            return new String(bytesEncryptBase64);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Decrypt data with private key
     */
    public static String decryptData(PrivateKey privateKey, String data) {
        try {
            // Base64 decoding
            byte[] bytesEncrypt = Base64.getDecoder().decode(data);

            // Decrypt data
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(cipher.doFinal(bytesEncrypt));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }
}
