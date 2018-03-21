package me.chinatsui.research.other;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/**
 * Created by chinatsui on 30/01/2018.
 */
public class KeyStoreTest {

    public static void main(String[] args)
            throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException,
            KeyStoreException, IOException, InvalidKeyException {
//        new KeyStoreTest().printPrivateKeyBase64();
        new KeyStoreTest().printCertificate();
    }

    public void printPrivateKeyBase64() throws KeyStoreException, IOException, CertificateException,
            NoSuchAlgorithmException, UnrecoverableKeyException, InvalidKeyException {
        KeyStore keyStore = KeyStore.getInstance("JKS");

        FileInputStream storeFis = new FileInputStream("/Users/chinatsui/Tradeshift/Frontend/oiosaml/certificate/keystore");
        char[] password = "Test1234".toCharArray();
        keyStore.load(storeFis, password);

        Key key = keyStore.getKey("saml", password);
        System.out.println(key.getAlgorithm());
        System.out.println(key.getFormat());

        System.out.println(new BASE64Encoder().encode(key.getEncoded()));
    }

    public void printCertificate() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");

        FileInputStream storeFis = new FileInputStream("/Users/chinatsui/Tradeshift/Frontend/oiosaml/certificate/keystore");
        char[] password = "Test1234".toCharArray();
        keyStore.load(storeFis, password);

        Certificate certificate = keyStore.getCertificate("saml");
        System.out.println(certificate.toString());
        System.out.println("==== BASE 64 String ====");
        System.out.println(new BASE64Encoder().encode(certificate.getEncoded()));
    }

}
