package com.xiamu.publisher.aes;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

class AESKeyGenerator {

    public static SecretKey generateKey(String passWord) throws Exception {
        //获取一个密钥生成器实例
        String ALGORITHM="AES";
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(ALGORITHM);
        SecureRandom random = new SecureRandom();
        random.setSeed(passWord.getBytes());//设置加密用的种子，密钥
        keyGenerator.init(random);
        SecretKey secretKey = keyGenerator.generateKey();
        //把上面的密钥存起来
        Path keyPath = Paths.get("D:/github/test_publisher/aes/aes.key");
        Files.write(keyPath, secretKey.getEncoded());
        System.out.println(secretKey.toString());
        return secretKey;
    }

    public static SecretKey readKey(Path keyPath) throws Exception {
        //读取存起来的密钥
        byte[] keyBytes = Files.readAllBytes(keyPath);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        return keySpec;
    }
}
