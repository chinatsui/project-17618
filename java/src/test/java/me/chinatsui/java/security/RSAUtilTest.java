package me.chinatsui.java.security;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RSAUtilTest {

    private String data;
    private Path publicKeyPath;
    private Path privateKeyPath;

    @Before
    public void setup() throws URISyntaxException {
        this.data = "The quick brown fox jumps over a lazy dog.";

        // ssh-keygen -f id_rsa.pub -e -m pkcs8
        publicKeyPath = Paths.get(Thread.currentThread().getContextClassLoader().getResource("public_key").toURI());

        // openssl pkcs8 -topk8 -inform PEM -outform PEM -in id_rsa -nocrypt
        privateKeyPath = Paths.get(Thread.currentThread().getContextClassLoader().getResource("private_key").toURI());
    }

    @Test
    public void test_encryption_and_decryption() {
        PublicKey publicKey = RSAUtil.getPublicKey(publicKeyPath);
        String encrypted = RSAUtil.encryptData(publicKey, data);

        PrivateKey privateKey = RSAUtil.getPrivateKey(privateKeyPath);
        String deprecated = RSAUtil.decryptData(privateKey, encrypted);

        Assert.assertEquals(data, deprecated);
    }

    @Test
    public void test_sign_and_verification()
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException {
        String data = "The quick brown fox jumps over a lazy dog.";

        // Sign data
        PrivateKey privateKey = RSAUtil.getPrivateKey(privateKeyPath);
        Signature signature = Signature.getInstance("Sha1WithRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        byte[] signed = signature.sign();

        // Signature verification
        PublicKey publicKey = RSAUtil.getPublicKey(publicKeyPath);
        Signature signature2 = Signature.getInstance("Sha1WithRSA");
        signature2.initVerify(publicKey);
        signature2.update(data.getBytes("UTF-8"));
        boolean verified = signature2.verify(signed);

        Assert.assertTrue(verified);
    }

    @Test
    public void test_rsa_review() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        // Given the data to be encrypted
        String data = "The quick brown fox jumps over a lazy dog.";
        System.out.println("Before encryption: " + data);

        // 1. Generate the public/private key pair.
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 2. Get the public key from the key pair.
        PublicKey publicKey = keyPair.getPublic();

        // 3. Get the private key from the key pair.
        PrivateKey privateKey = keyPair.getPrivate();

        // 4. To encrypt the data.
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());

        // 5. Do Base64 encoding.
        byte[] encodeBase64 = Base64.getEncoder().encode(encryptedData);
        System.out.println(" After encryption: " + new String(encodeBase64));

        // 6. Do Base64 decoding.
        byte[] decodeBase64 = Base64.getDecoder().decode(encodeBase64);

        // 7. To decrypt the cryptograph.
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = cipher.doFinal(decodeBase64);
        System.out.println(" After decryption: " + new String(decryptedData));
    }
}
