package com.netintech.xfquartz.dao.xf;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author: zhangyue
 * @date: 2018/10/26 13:48
 * @description:
 */
@Mapper
public interface XfSupplementalUrgeDao {

    Integer getXfSupplementalUrgeCount(Map<String, Object> map);
}
