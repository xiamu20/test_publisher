package aes;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;

public class AESDecrypt extends UDF {

    public String evaluate(String content, String secret) throws Exception {
        if (StringUtils.isBlank(content)) {
            throw new Exception("content not is null");
        }
        if (StringUtils.isBlank(secret)) {
            secret = "2000";
        }
        return AESUtil.decrypt(content, secret);
    }

    public static void main(String[] args) {
        try {
            System.out.println(new AESDecrypt().evaluate("13B5A43D90FBB91793CB43AA5831A64E", "2000"));
//            test
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
