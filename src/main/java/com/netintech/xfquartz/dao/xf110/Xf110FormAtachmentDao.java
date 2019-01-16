package com.netintech.xfquartz.dao.xf110;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.XfFormAtachment;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年09月20日 12时57分57秒
 */


public interface Xf110FormAtachmentDao extends BaseDao<XfFormAtachment> {
	
	int getXfFormAtachmentCount(Map<String, Object> map);

	List<XfFormAtachment> getXfFormAtachmentList(Map<String, Object> map);

	void exDelete(String ids);

	List<XfFormAtachment> getXfFormAtachmentList2();

	void updateBatch2(List<XfFormAtachment> ltXfFormAtachment);

	void updateById2(XfFormAtachment xfFormAtachment);
	
}
