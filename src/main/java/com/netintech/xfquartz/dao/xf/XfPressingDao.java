package com.netintech.xfquartz.dao.xf;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.XfPressing;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年08月17日 10时37分58秒
 */


public interface XfPressingDao extends BaseDao<XfPressing> {
	
	int getXfPressingCount(Map<String, Object> map);

	List<XfPressing> getXfPressingList(Map<String, Object> map);

	void exDelete(String ids);

	List<XfPressing> getXfPressingList2(Map<String, Object> map);

	void updateById2(XfPressing p);
	
}
