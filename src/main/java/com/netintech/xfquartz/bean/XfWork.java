package com.netintech.xfquartz.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年06月21日 18时05分13秒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XfWork implements Serializable {
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
	 *  @Fields IncomingPhone : 来电号码
	 * 
	 * */
	private String incomingPhone;
	/** 
	 *  @Fields FormStatusName : 工单状态（名称）
	 * 
	 * */
	private String formStatusName;
	/** 
	 *  @Fields FormTypeName : 工单类型（名称）
	 * 
	 * */
	private String formTypeName;
	/** 
	 *  @Fields Title : 标题
	 * 
	 * */
	private String title;
	/** 
	 *  @Fields CreateTime : 工单创建时间
	 * 
	 * */
	private String createTime;
	/** 
	 *  @Fields Uid : 成员u_id
	 * 
	 * */
	private String userId;
	/** 
	 *  @Fields PlanTime : 计划完成时间
	 * 
	 * */
	private String planTime;
	/** 
	 *  @Fields CusName : 客户姓名
	 * 
	 * */
	private String cusName;
	/** 
	 *  @Fields CusSex : 客户性别
	 * 
	 * */
	private String cusSex;
	/** 
	 *  @Fields CusPhone : 联系号码
	 * 
	 * */
	private String cusPhone;
	/** 
	 *  @Fields JjcdName : 紧急程度（名称）
	 * 
	 * */
	private String jjcdName;
	/** 
	 *  @Fields FormOriginName : 工单来源（名称）
	 * 
	 * */
	private String formOriginName;
	/** 
	 *  @Fields BusinessTypeName : 一级业务类型（名称）
	 * 
	 * */
	private String businessTypeName;
	/** 
	 *  @Fields BusinessTypeChildName : 二级业务类型（名称）
	 * 
	 * */
	private String businessTypeChildName;
	/** 
	 *  @Fields BusinessTypeGrandsonName : 三级业务类型（名称）
	 * 
	 * */
	private String businessTypeGrandsonName;
	/** 
	 *  @Fields AreaName : 归属地
	 * 
	 * */
	private String areaName;
	/** 
	 *  @Fields BusiAddress : 归属地地址
	 * 
	 * */
	private String busiAddress;
	/** 
	 *  @Fields ContentText : 工单内容
	 * 
	 * */
	private String contentText;
	/** 
	 *  @Fields Comments : 备注
	 * 
	 * */
	private String comments;
	/** 
	 *  @Fields IsSign : 是否已签收，0-未签收，1-已签收
	 * 
	 * */
	private Integer isSign;
	/** 
	 *  @Fields IsFinish : 是否已完成，0-未完成，1-已完成
	 * 
	 * */
	private Integer isFinish;
	/** 
	 *  @Fields IsFetch : 是否已抽取，0-未抽取，1-已抽取
	 * 
	 * */
	private Integer isFetch;
	/** 
	 *  @Fields UpdateTime : 更新时间
	 * 
	 * */
	private Date updateTime;
	/**
	 *  @Fields PullTime : 数据创建时间
	 *
	 * */
	private Date pullTime;

	private String hisadv;//民生110历史反馈内容

	private String addcontent;//民生110补充催办内容

	private Integer matterId;

}

