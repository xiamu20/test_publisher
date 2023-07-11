package com.xiamu.publisher.aes;

import javax.crypto.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

public class AESDecrypt {
    public static String testDecrypt(String content, String passWord) throws Exception {
        String ALGORITHM="AES";
       // Path keyPath = Paths.get("D:/github/test_publisher/aes/aes.key");
        //读取存起来的密钥
      //  SecretKey secretKey = AESKeyGenerator.readKey(keyPath);
        //2、生成/读取用于加解密的密钥
        SecretKey secretKey = AESKeyGenerator.generateKey(passWord);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        //String content = "pK9Xw4zqTMXYraDadSGJE3x/ftrDxIg2AM/acq0uixA=";//经过Base64加密的待解密的内容
        byte[] encodedBytes = Base64.getDecoder().decode(content.getBytes());
        byte[] result = cipher.doFinal(encodedBytes);//对加密后的字节数组进行解密
        System.out.println("Result: " + new String(result));
        return new String(result);
    }

    public static void main(String[] args) throws Exception {
        String s = testDecrypt("Heq2VKW4Xp7rR0EVsnPlBQ==", "2000");
        System.out.println(s);
    }
}
