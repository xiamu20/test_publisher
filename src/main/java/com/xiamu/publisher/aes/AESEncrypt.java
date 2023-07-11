package com.xiamu.publisher.aes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import java.util.Base64;

import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

public class AESEncrypt {
  public  static String testEncrypt(String content, String passWord) throws Exception {
      String ALGORITHM="AES";
      //1、指定算法、获取Cipher对象
      Cipher cipher = Cipher.getInstance(ALGORITHM);//算法是AES
      //2、生成/读取用于加解密的密钥
      SecretKey secretKey = AESKeyGenerator.generateKey(passWord);
      //3、用指定的密钥初始化Cipher对象，指定是加密模式，还是解密模式
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      //4、更新需要加密的内容
      cipher.update(content.getBytes());
      //5、进行最终的加解密操作
      byte[] result = cipher.doFinal();//加密后的字节数组
      String base64Result = Base64.getEncoder().encodeToString(result);//对加密后的字节数组进行Base64编码
      //System.out.println("Result: " + base64Result);
      return base64Result;
  }

    public static void main(String[] args) throws Exception {
        String test = testEncrypt("test", "2000");
        System.out.println(test);
    }
}
