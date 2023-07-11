package com.xiamu.publisher.controller;
import com.xiamu.publisher.aes.AESDecrypt;
import com.xiamu.publisher.aes.AESEncrypt;
import com.xiamu.publisher.bean.User;
import com.xiamu.publisher.mapper.UserBakMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//http://localhost:8080/encrypt?id=1&field=email&passWord=2000
//http://localhost:8080/decrypt?id=1&field=email&passWord=2000
@RestController
public class UserController {
    @Resource
    UserBakMapper userBakMapper;
    @GetMapping("/encrypt")
    public String encrypt(String id, String field, String passWord) throws Exception {
        List<User> select = userBakMapper.select(id);
        AESEncrypt aesEncrypt = new AESEncrypt();
        ArrayList<Integer> list = new ArrayList<>();
        if (select.isEmpty()){
            List<User> user = userBakMapper.getUser(id);
            for (User u:user
                 ) {
                if(field.equals("email")){
                    String encrypt = aesEncrypt.testEncrypt(u.getEmail(), passWord);
                    System.out.println(encrypt);
                    u.setEmail(encrypt);
                    u.setStatus("encrypt");
                    System.out.println(u.toString());
                    int insert = userBakMapper.insert(u);
                    list.add(insert);
                }else {
                    u.setName("");
                    u.setStatus("encrypt");
                    return "";
                }
            }

            return "insert: "+list;
        }else {

            int delete = userBakMapper.delete(id);
            List<User> user = userBakMapper.getUser(id);
            for (User u:user
                    ) {
                if(field.equals("email")){
                    String encrypt =aesEncrypt.testEncrypt(u.getEmail(), passWord);
                    System.out.println(encrypt);
                    u.setEmail(encrypt);
                    u.setStatus("encrypt");
                    int insert = userBakMapper.insert(u);
                    list.add(insert);
                }else {
                    u.setName("");
                    u.setStatus("encrypt");
                    return "";
                }
            }

            return "insert: "+list;

        }

    }

    @GetMapping("/decrypt")
    public List<User> decrypt(String id, String field, String passWord) throws Exception {
        List<User> user = userBakMapper.select(id);
        AESDecrypt aesDecrypt = new AESDecrypt();
        if(user.isEmpty()){
            System.out.println("未加密数据");
        }else {
            for (User u:user
                 ) {
               if (field.equals("email")){
                   String decrypt = aesDecrypt.testDecrypt(u.getEmail(), passWord);
                   u.setEmail(decrypt);
               }
            }
        }
        return user;
    }
}
