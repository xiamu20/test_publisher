package com.xiamu.publisher.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiamu.publisher.bean.SelectSwitch;
import com.xiamu.publisher.bean.StatisticVo;
import com.xiamu.publisher.redis.redisson.MyRedissonConfig;
import com.xiamu.publisher.mapper.SelectSwitchMapper;
import com.xiamu.publisher.service.StatisticAndReportService;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledDataSendingTask {

 //   @Value("${task.enabled")// 通过配置文件读取参数值
//    private boolean taskEnabled=false;

  //  public  void  setTaskEnabled(boolean enabled){
  //      this.taskEnabled=enabled;
   // }


    @Autowired
    private StatisticAndReportService statisticAndReportService;
    @Autowired
    SelectSwitchMapper selectSwitchMapper;
    @Autowired
    MyRedissonConfig myRedissonConfig;
   //@Scheduled(fixedRate = 10000) //每10秒

    @Scheduled(cron = "0 1 1 ? * *")
    public void autoCalculateUserStatisticAndSendEmail() throws MessagingException {
        String lockKey="lockKey";
        RLock lock = myRedissonConfig.redisson().getLock(lockKey);
        try {
            lock.lock(10, TimeUnit.SECONDS);
            List<SelectSwitch> status = selectSwitchMapper.getStatus();
            System.out.println(status);
            String taskEnabled = status.get(0).getStatus2();

            System.out.println(taskEnabled);


            if (taskEnabled.equals("开启")){
                StatisticVo vo = statisticAndReportService.statisticAddUserReport();
                String content = statisticAndReportService.renderReport(vo);
                statisticAndReportService.sendMail("新增用户报告", content);
            }
        }finally {
            lock.unlock();
        }


    }
}
