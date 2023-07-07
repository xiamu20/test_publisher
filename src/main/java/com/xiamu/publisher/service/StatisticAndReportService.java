package com.xiamu.publisher.service;

import com.xiamu.publisher.bean.StatisticVo;
import com.xiamu.publisher.bean.UserStatisticPo;
import com.xiamu.publisher.mapper.UserStatisticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticAndReportService {
    @Autowired
    private UserStatisticMapper userStatisticMapper;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment environment;
    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    public StatisticVo  statisticAddUserReport(){
        List<UserStatisticPo> userStatisticPos = userStatisticMapper.statisticUserCnt(30);
        StatisticVo vo = new StatisticVo();
        vo.setHtmlTitle("每日新增用户统计");
        vo.setTableTitle(String.format("【%s】新增用户报表", LocalDate.now()));
        vo.setList(userStatisticPos);
     //   System.out.println(vo);
        return vo;


    }
    public String renderReport(StatisticVo vo){
        Context context = new Context();
        context.setVariable("vo",vo);
        String report = springTemplateEngine.process("report", context);
        System.out.println(report);

        return report;
    }

    /**
     * 发送邮件的逻辑
     *
     * @param title
     * @param content
     * @throws MessagingException

     */
    @Value("${spring.mail.username}")
    private String account;
  //  @Value("${task.enabled}") // 通过配置文件读取参数值，例如true表示任务开启，false表示任务关闭
   // private boolean taskEnabled;
    public void sendMail(String title, String content) throws MessagingException {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);

        //邮件发送人，从前面的配置参数中拿，若没有配置，则使用默认的xhhuiblog@163.com
        mimeMessageHelper.setFrom(account);
        //邮件接收人，可以是多个
        mimeMessageHelper.setTo("327918545@qq.com");
        //邮件主题
        mimeMessageHelper.setSubject(title);
        //邮件内容
        mimeMessageHelper.setText(content, true);

        // 解决linux上发送邮件时，抛出异常 JavaMailSender no object DCH for MIME type multipart/mixed
        Thread.currentThread().setContextClassLoader(javax.mail.Message.class.getClassLoader());
        javaMailSender.send(mimeMailMessage);
    }


}
