package com.xiamu.publisher.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;

@Slf4j
@Api(tags = "发送邮件", description = "d发送邮件")
@RestController
@RequiredArgsConstructor
public class EmailController {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
     private String username;

    @PostMapping("sendmail")
    public String sendMail(@ApiParam("收件地址")@RequestParam(value = "address",defaultValue ="false" ) String address ,
                           @RequestParam(value = "subject",defaultValue ="false" ) String subject ,
                           @RequestParam(value = "text",defaultValue ="false" ) String text ,
                           @RequestParam(value = "file",defaultValue ="false" ) MultipartFile file
                           ) throws MessagingException, IOException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(username);
        mimeMessageHelper.setTo(new String[]{address});
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);
        //文件路径
        byte[] bytes = file.getBytes();
        String name = file.getName();
        mimeMessageHelper.addAttachment(name, new ByteArrayResource(bytes));
        log.info("fileName:{}",name);
        javaMailSender.send(mimeMessage);

        return "send sucess";
    }

}
