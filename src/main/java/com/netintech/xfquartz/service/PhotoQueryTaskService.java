package com.netintech.xfquartz.service;

import com.netintech.xfquartz.bean.PhotoQueryTask;
import com.netintech.xfquartz.dao.qjt.PhotoQueryTaskDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangyue
 * @date: 2018/11/8 11:01
 * @description:
 */
@Service
public class PhotoQueryTaskService {
    @Resource
    PhotoQueryTaskDao photoQueryTaskDao;

    public List<PhotoQueryTask> getPhotoQueryTaskList(Map<String, Object> map){
        return photoQueryTaskDao.getPhotoQueryTaskList(map);
    }
}
