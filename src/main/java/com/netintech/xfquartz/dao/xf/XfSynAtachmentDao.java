package com.netintech.xfquartz.dao.xf;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.XfSynAtachment;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年06月26日 18时04分37秒
 */

public interface XfSynAtachmentDao extends BaseDao<XfSynAtachment> {
	
	int getXfSynAtachmentCount(Map<String, Object> map);

	List<XfSynAtachment> getXfSynAtachmentList(Map<String, Object> map);

	void exDelete(String ids);

	void insert2(XfSynAtachment x);

	void insertBatch2(List<XfSynAtachment> ltXfSynAtachment);
	
}
