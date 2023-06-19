package com.xiamu.publisher.task;

import com.xiamu.publisher.bean.StatisticVo;
import com.xiamu.publisher.Redis.redisson.MyRedissonConfig;
import com.xiamu.publisher.service.StatisticAndReportService;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledDataSendingTask {

 //   @Value("${task.enabled")// 通过配置文件读取参数值
    private boolean taskEnabled=false;

    public  void  setTaskEnabled(boolean enabled){
        this.taskEnabled=enabled;
    }


    @Autowired
    private StatisticAndReportService statisticAndReportService;
    @Autowired
    MyRedissonConfig myRedissonConfig;
    @Scheduled(fixedRate = 3000) //每3秒
    //@Scheduled(cron = "0 0 0 * * *") // 每天凌晨执行任务
    public void autoCalculateUserStatisticAndSendEmail() throws MessagingException {
        String lockKey="lockKey";
        RLock lock = myRedissonConfig.redisson().getLock(lockKey);
        try {
            lock.lock(10, TimeUnit.SECONDS);
            if (taskEnabled){
                StatisticVo vo = statisticAndReportService.statisticAddUserReport();
                String content = statisticAndReportService.renderReport(vo);
                statisticAndReportService.sendMail("新增用户报告", content);
            }
        }finally {
            lock.unlock();
        }


    }
}
