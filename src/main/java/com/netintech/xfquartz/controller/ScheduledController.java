package com.netintech.xfquartz.controller;

import ch.qos.logback.classic.Logger;
import com.netintech.xfquartz.service.PhotoQueryTaskService;
import com.netintech.xfquartz.service.ScheduledService;
import com.netintech.xfquartz.websocket.MyWebSocket;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangyue
 * @date: 2018/10/26 13:21
 * @description:
 */
@RestController
public class ScheduledController {

    @Autowired
    ScheduledService scheduledService;

    @Autowired
    PhotoQueryTaskService photoQueryTaskService;

    private final static Logger logger = (Logger) LoggerFactory.getLogger(ScheduledController.class);

    /**
     * 每15秒执行一次
     * @return
     */
    @GetMapping("/hello")
    @Scheduled(cron = "0/15 * * * * MON-SAT")
    public void xfSupplementalUrgeCount(){
        Map<String,MyWebSocket> map=MyWebSocket.getConnections();
        for(String in:map.keySet()){
            Integer count= scheduledService.getXfSupplementalUrgeCount(in);
            try {
                MyWebSocket.sendMessageToUser(count.toString(),map.get(in).getSession());
                logger.info("发送补充催办数量"+count+"给用户"+in+"成功!");
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("发送补充催办数量"+count+"给用户"+in+"失败!");
            }
        }
    }

    @GetMapping("/testPhoto")
    public Object getPhotoQueryTaskList(){
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("start",0);
        map.put("end",20);
        return photoQueryTaskService.getPhotoQueryTaskList(map);
    }
}
