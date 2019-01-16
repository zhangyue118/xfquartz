package com.netintech.xfquartz.dao.xf;

import com.netintech.xfquartz.base.BaseDao;
import com.netintech.xfquartz.bean.Workconfirm;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author  - - admin
 * @date - 2018年12月28日 16时44分26秒
 */


public interface WorkconfirmDao extends BaseDao<Workconfirm> {
	
	int getWorkconfirmCount(Map<String, Object> map);

	List<Workconfirm> getWorkconfirmList(Map<String, Object> map);

	void exDelete(String ids);
	
}
