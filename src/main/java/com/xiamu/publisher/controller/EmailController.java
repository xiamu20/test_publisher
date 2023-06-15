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
//http://localhost:8080/sendmail?address=327918545@qq.com&subject=subject&text=text
@Slf4j
@Api(tags = "发送邮件", description = "d发送邮件")
@RestController
@RequiredArgsConstructor
public class EmailController {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
     private String username;

   // MultipartFile 接口是 Spring 框架用于处理上传文件的通用接口，它可以支持多种文件格式，包括但不限于以下常见的文件格式：
  // 图像文件：JPEG/JPG、PNG、GIF、BMP 等常见的图像格式。
   // 文档文件：PDF、DOC/DOCX、XLS/XLSX、PPT/PPTX、TXT 等常见的文档格式。
 //  压缩文件：ZIP、RAR、7Z 等常见的压缩文件格式。
  //  视频文件：MP4、AVI、MOV、WMV 等常见的视频格式。
   // 音频文件：MP3、WAV、FLAC、AAC 等常见的音频格式。
   //数据文件：CSV、JSON、XML 等常见的数据格式
    @PostMapping("sendmail")
    public String sendMail(@ApiParam("收件地址")@RequestParam(value = "address",defaultValue ="false" ) String address ,
                           @ApiParam("标题")@RequestParam(value = "subject",defaultValue ="false" ) String subject ,
                           @ApiParam("正文")@RequestParam(value = "text",defaultValue ="false" ) String text ,
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
