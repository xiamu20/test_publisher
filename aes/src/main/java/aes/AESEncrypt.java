package aes;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;

public class AESEncrypt extends UDF {

    public String evaluate(String content, String secret) throws Exception {
        if (StringUtils.isBlank(content)) {
            throw new Exception("content not is null");
        }
        if (StringUtils.isBlank(secret)) {
            secret = "2000";
        }
        return AESUtil.encrypt(content, secret);
    }


    public static void main(String[] args) {
        try {
            System.out.println(new AESEncrypt().evaluate("4162", "2000"));
//            11A3557F7F95FA58016650C51C28A3A9
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
