package com.xiamu.publisher.controller;

import com.xiamu.publisher.mapper.SelectSwitchMapper;
import com.xiamu.publisher.mapper.UpdateSwitchMapper;
import com.xiamu.publisher.task.ScheduledDataSendingTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    ScheduledDataSendingTask dataSendingTask;
    @Autowired
    SelectSwitchMapper selectSwitchMapper;
    @Autowired
    UpdateSwitchMapper updateSwitchMapper;
    @GetMapping("/task/enable")
    public List<SelectSwitchMapper>  enableTaskState(){
        List<SelectSwitchMapper> status = selectSwitchMapper.getStatus();
        return status;
    }
    @PostMapping("/task/enable")
    public String  enableTask(@RequestParam boolean enabled){
        dataSendingTask.setTaskEnabled(enabled);
        if (enabled){
            updateSwitchMapper.updateStatus("开启");
            return "开启";
        }else {
            updateSwitchMapper.updateStatus("关闭");
            return "关闭";
        }



    }
}
