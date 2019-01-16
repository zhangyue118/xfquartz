package com.netintech.xfquartz.dao.xf;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.XfWork;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年06月21日 18时05分13秒
 */

public interface XfWorkDao extends BaseDao<XfWork> {
	
	int getXfWorkCount(Map<String, Object> map);

	List<XfWork> getXfWorkList(Map<String, Object> map);

	void exDelete(String ids);

	List<XfWork> getXfWorkList2(Map<String, Object> map);

	void updateById2(XfWork x);

	List<XfWork> getXfWorkListNoRepeat2();

	XfWork getByWorkId2(String workId);
	
}
