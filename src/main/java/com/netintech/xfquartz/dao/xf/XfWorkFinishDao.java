package com.netintech.xfquartz.dao.xf;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.XfWorkFinish;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @author administrator
 * @date - 2018年06月21日 18时05分13秒
 */

public interface XfWorkFinishDao extends BaseDao<XfWorkFinish> {
	
	int getXfWorkFinishCount(Map<String, Object> map);

	List<XfWorkFinish> getXfWorkFinishList(Map<String, Object> map);

	void exDelete(String ids);

	int getXfWorkFinishCount2(Map<String, Object> map);

	void insert2(XfWorkFinish x);

	void insertBatch2(List<XfWorkFinish> list);
	
}
