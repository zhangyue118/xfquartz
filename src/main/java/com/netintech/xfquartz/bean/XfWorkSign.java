package com.netintech.xfquartz.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年06月21日 18时05分13秒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XfWorkSign implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : ID,唯一标识
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields BusiNumber : 工单编号
	 * 
	 * */
	private String busiNumber;
	/** 
	 *  @Fields FormId : 工单ID
	 * 
	 * */
	private String formId;
	/** 
	 *  @Fields CreateTime : 数据创建时间
	 * 
	 * */
	private java.util.Date createTime;
	/** 
	 *  @Fields IsHandle : 是否已处理,0-未处理,1-已处理
	 * 
	 * */
	private Integer isHandle;

}

