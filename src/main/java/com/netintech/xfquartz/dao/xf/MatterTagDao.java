package com.netintech.xfquartz.dao.xf;

import com.netintech.xfquartz.bean.Tag;

import java.util.List;

public interface MatterTagDao {

	List<Tag> getListByMatterId(int matterId);
	
	void savaTag(Tag tag);
	
	void updataTag(Tag tag);
	
	Tag findMatterIdData(String matterId);

}
