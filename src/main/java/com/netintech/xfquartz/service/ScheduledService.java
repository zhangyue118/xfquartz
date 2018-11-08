package com.netintech.xfquartz.service;

import ch.qos.logback.classic.Logger;
import com.netintech.xfquartz.dao.xf.XfSupplementalUrgeDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangyue
 * @date: 2018/10/26 13:22
 * @description:
 */
@Service
public class ScheduledService {

    @Autowired
    private XfSupplementalUrgeDao xfSupplementalUrgeDao;

    private final static Logger logger = (Logger) LoggerFactory.getLogger(ScheduledService.class);

    public Integer getXfSupplementalUrgeCount(String userid){
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("userId", userid);
        return xfSupplementalUrgeDao.getXfSupplementalUrgeCount(map);
    }
}
