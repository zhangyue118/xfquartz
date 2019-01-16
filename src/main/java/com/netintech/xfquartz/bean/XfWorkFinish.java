package com.netintech.xfquartz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
public class XfWorkFinish implements Serializable {
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
	 *  @Fields Comments : 反馈内容
	 * 
	 * */
	private String comments;
	/** 
	 *  @Fields Attachment1 : 附件1,base64编码文本
	 * 
	 * */
	private String attachment1;
	/** 
	 *  @Fields Attachment2 : 附件2，base64编码文本
	 * 
	 * */
	private String attachment2;
	/** 
	 *  @Fields Attachment3 : 附件3，base64编码文本
	 * 
	 * */
	private String attachment3;
	/** 
	 *  @Fields DoActionName : 操作名称
	 * 
	 * */
	private String doActionName;
	/** 
	 *  @Fields CreateTime : 数据创建时间
	 * 
	 * */
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private java.util.Date createTime;
	/** 
	 *  @Fields IsHandle : 是否已处理,0-未处理,1-已处理
	 * 
	 * */
	private Integer isHandle;
	
	private Integer matterid;//事项id

	private String unstatisfyappeal;//不满意申诉理由

	private String unstatisfytype;//不满意类型

	private String timeoutappeal;//超期申诉理由

}

