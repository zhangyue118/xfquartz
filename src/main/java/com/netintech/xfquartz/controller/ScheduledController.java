package com.netintech.xfquartz.controller;

import ch.qos.logback.classic.Logger;
import com.netintech.xfquartz.bean.XfWorkFinish;
import com.netintech.xfquartz.dao.xf.XfWorkFinishDao;
import com.netintech.xfquartz.dao.xf110.Xf110WorkDao;
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
import java.util.List;
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

    @Autowired
    private Xf110WorkDao xfWorkDao;

    @Autowired
    private XfWorkFinishDao xfWorkFinishDao;

    private final static Logger logger = (Logger) LoggerFactory.getLogger(ScheduledController.class);

    /**
     * 每15秒执行一次
     * @return
     */
    @GetMapping("/hello")
    //@Scheduled(cron = "0/15 * * * * MON-SAT")
    @Scheduled(fixedDelay = 10000)//以一个固定延迟时间10秒钟调用一次执行 这个周期是以上一个调用任务的##完成时间##为基准，在上一个任务完成之后，10s后再次执行
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

    @GetMapping("/testPhoto2")
    public Object getPhotoQueryTaskList2(){
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("start",0);
        map.put("end",20);
        return xfWorkDao.getXfWorkList2(map);
    }

    @GetMapping("/testPhoto3")
    public Object getPhotoQueryTaskList3(){
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("start",0);
        map.put("end",20);
        //return xfWorkService.getXfWorkList2(map);
        return xfWorkDao.getById(22865);
    }

    @GetMapping("/testPhoto4")
    public Object getPhotoQueryTaskList4(){
        Map<String, Object> map=new HashMap<String, Object>();
        List<XfWorkFinish> ltXfWorkFinish=xfWorkFinishDao.getXfWorkFinishList(map);
        return ltXfWorkFinish;
    }
}
