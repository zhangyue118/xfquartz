package com.netintech.xfquartz.dao.xf110;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.XfWorkSign;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年06月21日 18时05分13秒
 */


public interface Xf110WorkSignDao extends BaseDao<XfWorkSign> {
	
	int getXfWorkSignCount(Map<String, Object> map);

	List<XfWorkSign> getXfWorkSignList(Map<String, Object> map);

	void exDelete(String ids);

	void insert2(XfWorkSign x);
	
}
