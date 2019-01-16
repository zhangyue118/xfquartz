package com.netintech.xfquartz.dao.xf110;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.XfWorkReject;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年06月21日 18时05分13秒
 */


public interface Xf110WorkRejectDao extends BaseDao<XfWorkReject> {
	
	int getXfWorkRejectCount(Map<String, Object> map);

	List<XfWorkReject> getXfWorkRejectList(Map<String, Object> map);

	void exDelete(String ids);

	void insert2(XfWorkReject x);
	
}
