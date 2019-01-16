package com.netintech.xfquartz.dao.xf;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.XfMatters;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年03月20日 09时26分15秒
 */


public interface XfMattersDao extends BaseDao<XfMatters> {

	List<XfMatters> getByWorkid(String busiNumber);

	List<XfMatters> getByWorkid2(String workid);

	Integer getByMaxOrder2(Map<String, Object> map1);

	Integer getByMaxOrder(Map<String, Object> map);

	List<XfMatters> getByEntityAndPressing(Map<String, Object> map);
}
