package aes;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Scanner;


/**
 * AES加密解密工具类
 *
 * @author Super白
 */
public class AESUtil {
    private static final String defaultCharset = "UTF-8";
    private static final String KEY_AES = "AES";
    private static final String SECRET = "2000";

    /**
     * AES 加密函数方法
     *
     * @param content 加密内容
     * @param secret  秘钥
     * @return
     */
    public static String encrypt(String content, String secret) {
        return doAES(content, secret, Cipher.ENCRYPT_MODE);
    }

    /**
     * AES 解密函数方法
     *
     * @param content 解密内容
     * @param secret  秘钥
     * @return
     */
    public static String decrypt(String content, String secret) {
        return doAES(content, secret, Cipher.DECRYPT_MODE);
    }

    /**
     * 加解密
     *
     * @param content 待处理数据
     * @param secret  密钥
     * @param mode    加解密mode
     * @return
     */
    private static String doAES(String content, String secret, int mode) {
        try {
            if (StringUtils.isBlank(content) || StringUtils.isBlank(secret)) {
                return null;
            }
            //判断是加密还是解密
            boolean encrypt = mode == Cipher.ENCRYPT_MODE;
            byte[] data;

            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator kgen = KeyGenerator.getInstance(KEY_AES);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            //2.根据cneodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            secureRandom.setSeed(secret.getBytes());
            //生成一个128位的随机源,根据传入的字节数组
            kgen.init(128, secureRandom);
            //3.产生原始对称密钥
            SecretKey secretKey = kgen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] enCodeFormat = secretKey.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, KEY_AES);
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(KEY_AES);// 创建密码器
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(mode, keySpec);// 初始化

            if (encrypt) {
                data = content.getBytes(defaultCharset);
                System.out.println("encryot"+data);
            } else {
                data = parseHexStr2Byte(content);
                System.out.println("decrypt"+data);
            }
            byte[] result = cipher.doFinal(data);
            System.out.println(result);

            if (encrypt) {
                //将二进制转换成16进制
                System.out.println("16"+parseByte2HexStr(result));
                return parseByte2HexStr(result);
            } else {
                return new String(result, defaultCharset);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * 加密
         */
        System.out.println("使用AES对称加密，请输入秘钥");
        String Secret = scanner.next();

        System.out.println("请输入要加密的内容:");
        String content = scanner.next();

        System.out.println("根据输入的秘钥" + Secret + "加密后的密文是:" + encrypt(content, Secret));

        /*
         * 解密
         */
        System.out.println("使用AES对称解密，请输入加密的规则：(须与加密相同)");
        Secret = scanner.next();
        System.out.println("请输入要解密的内容（密文）:");
        content = scanner.next();
        System.out.println("根据输入的秘钥" + Secret + "解密后的明文是:" + decrypt(content, Secret));
    }
}
