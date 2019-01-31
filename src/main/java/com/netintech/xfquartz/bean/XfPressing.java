package com.netintech.xfquartz.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName:  
 * @Description: 补充催办
 * @author administrator
 * @date - 2018年08月17日 10时37分58秒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XfPressing implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
	/** 
	 *  @Fields Id : id
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields FormId : 工单ID
	 * 
	 * */
	private String formId;
	/** 
	 *  @Fields BusiNumber : 工单号
	 * 
	 * */
	private String busiNumber;
	/** 
	 *  @Fields AddTime : 催办时间
	 * 
	 * */
	private String addTime;
	/** 
	 *  @Fields AddContent : 催办内容
	 * 
	 * */
	private String addContent;
	/** 
	 *  @Fields Flag : 催办或补充标志（1补充，2催办）
	 * 
	 * */
	private Integer flag;
	/** 
	 *  @Fields CreateTime : 创建时间
	 * 
	 * */
	private java.util.Date createTime;
	/** 
	 *  @Fields IsFetch : 是否抽取，0-未抽取，1-已抽取
	 * 
	 * */
	private Integer isFetch;

	/**
	 *  @Fields matter_id : 事项id
	 *
	 * */
	private Integer matterId;

}

