package com.netintech.xfquartz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:  
 * @Description: 工单办结相关
 * @author administrator
 * @date - 2018年12月28日 16时44分26秒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workconfirm implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : 表记录唯一ID
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields XfMattersId : 信访工单ID,表记录唯一ID
	 * 
	 * */
	private Integer xfMattersId;
	/** 
	 *  @Fields CommunicationResult : 沟通结果
	 * 
	 * */
	private String communicationResult;
	/** 
	 *  @Fields Result : 信访办理结果
	 * 
	 * */
	private String result;
	/** 
	 *  @Fields Validity : 是否属实
	 * 
	 * */
	private String validity;
	/** 
	 *  @Fields CreateTime : 创建时间
	 * 
	 * */
	private Date createTime;
	/** 
	 *  @Fields Creater : 创建人
	 * 
	 * */
	private Integer creater;
	/** 
	 *  @Fields UpdateTime : 更新时间
	 * 
	 * */
	private Date updateTime;
	/** 
	 *  @Fields Updater : 更新人
	 * 
	 * */
	private Integer updater;

}

