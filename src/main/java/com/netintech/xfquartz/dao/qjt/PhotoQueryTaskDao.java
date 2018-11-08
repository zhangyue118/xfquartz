package com.netintech.xfquartz.dao.qjt;

import com.netintech.xfquartz.bean.PhotoQueryTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author: zhangyue
 * @date: 2018/11/8 11:04
 * @description:
 */
@Mapper
public interface PhotoQueryTaskDao {

    List<PhotoQueryTask> getPhotoQueryTaskList(Map<String, Object> map);
}
