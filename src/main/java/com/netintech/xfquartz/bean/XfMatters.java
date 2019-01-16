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
 * @date - 2018年03月20日 09时26分15秒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XfMatters implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : 表唯一标志 
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields XfDate : 信访日期
	 * 
	 * */
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private java.util.Date xfDate;
	/** 
	 *  @Fields XfName : 信访人姓名
	 * 
	 * */
	private String xfName;
	/** 
	 *  @Fields Sex : 性别
	 * 
	 * */
	private String sex;
	/** 
	 *  @Fields Age : 年龄
	 * 
	 * */
	private String age;
	/** 
	 *  @Fields Nation : 民族
	 * 
	 * */
	private String nation;
	/** 
	 *  @Fields Education : 文化水平，受教育程度
	 * 
	 * */
	private String education;
	/** 
	 *  @Fields PersonQty : 信访人数
	 * 
	 * */
	private Integer personQty;
	/** 
	 *  @Fields Unit : 信访人所在单位
	 * 
	 * */
	private String unit;
	/** 
	 *  @Fields Address : 信访人现住地址
	 * 
	 * */
	private String address;
	/** 
	 *  @Fields Contact : 信访者联系方式
	 * 
	 * */
	private String contact;
	/** 
	 *  @Fields Credentials : 信访者证件号码
	 * 
	 * */
	private String credentials;
	/** 
	 *  @Fields CredentialsType : 证件类型
	 * 
	 * */
	private String credentialsType;
	/** 
	 *  @Fields XfException : 信访异常内容
	 * 
	 * */
	private String xfException;
	/** 
	 *  @Fields ComplaintStage : 投诉阶段
	 * 
	 * */
	private String complaintStage;
	/** 
	 *  @Fields XfSource : 信访来源
	 * 
	 * */
	private String xfSource;
	/** 
	 *  @Fields XfType : 信访类型
	 * 
	 * */
	private String xfType;
	/** 
	 *  @Fields ComplaintType : 投诉类型
	 * 
	 * */
	private String complaintType;
	/** 
	 *  @Fields ComplaintSubType : 投诉子类型
	 * 
	 * */
	private String complaintSubType;
	/** 
	 *  @Fields SzComplaintType : 苏州投诉类型
	 * 
	 * */
	private String szComplaintType;
	/** 
	 *  @Fields XfForm : 信访形式
	 * 
	 * */
	private String xfForm;
	/** 
	 *  @Fields XfFeature : 信访特点
	 * 
	 * */
	private String xfFeature;
	/** 
	 *  @Fields XfDestination : 信访目的地
	 * 
	 * */
	private String xfDestination;
	/** 
	 *  @Fields ReceptionLeader : 接访领导
	 * 
	 * */
	private String receptionLeader;
	/** 
	 *  @Fields XfAppeal : 信访诉求
	 * 
	 * */
	private String xfAppeal;
	/** 
	 *  @Fields UndertakeDepartment : 承办单位
	 * 
	 * */
	private String undertakeDepartment;
	/** 
	 *  @Fields ResponsibilityDepartment : 责任单位
	 * 
	 * */
	private String responsibilityDepartment;
	/** 
	 *  @Fields ConcludeDeadline : 办结期限
	 * 
	 * */
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private java.util.Date concludeDeadline;
	/** 
	 *  @Fields Remark : 录入备注
	 * 
	 * */
	private String remark;
	/** 
	 *  @Fields TransactManner : 办理方式
	 * 
	 * */
	private String transactManner;
	/** 
	 *  @Fields AgentPolice : 经办民警
	 * 
	 * */
	private String agentPolice;
	/** 
	 *  @Fields IsRepeat : 是否重复，1表示是，0表示不是
	 * 
	 * */
	private Integer isRepeat;
	/** 
	 *  @Fields RepeatCount : repeatCount
	 * 
	 * */
	private Integer repeatCount;
	/** 
	 *  @Fields IsSfsu : 是否设法设诉，1表示是，0表示不是
	 * 
	 * */
	private Integer isSfsu;
	/** 
	 *  @Fields IsPush : 是否推送，1表示是，0表示不是
	 * 
	 * */
	private Integer isPush;
	/** 
	 *  @Fields IssueTime : 下发时间
	 * 
	 * */
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private java.util.Date issueTime;
	/** 
	 *  @Fields HandleOption : 拟办意见
	 * 
	 * */
	private String handleOption;
	/** 
	 *  @Fields AuditOption : 审核意见
	 * 
	 * */
	private String auditOption;
	/** 
	 *  @Fields LeaderOption : 领导批示
	 * 
	 * */
	private String leaderOption;
	/** 
	 *  @Fields Creater : 创建者
	 * 
	 * */
	private Integer creater;
	/** 
	 *  @Fields State : 事项状态（0-临时存放，1-自存自办，2-待下发，3-待签收，4- 承办退回，5-待回复，6-待审核，7-退回重办，8-审核中，9-已办结）
	 * 
	 * */
	private String state;
	/** 
	 *  @Fields Order : 登文序号
	 * 
	 * */
	private Integer order;
	/** 
	 *  @Fields CreateTime : 创建时间
	 * 
	 * */
	private java.util.Date createTime;
	/** 
	 *  @Fields InputTime : 录入时间
	 * 
	 * */
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private java.util.Date inputTime;
	/** 
	 *  @Fields Issuer : 下方人ID
	 * 
	 * */
	private Integer issuer;
	/** 
	 *  @Fields IsDelete : 是否是删除的 事项, 0 不是，1是
	 * 
	 * */
	private Integer isDelete;
	/** 
	 *  @Fields processCreatetime : 事项处理表创建时间
	 * 
	 * */
	private java.util.Date processCreatetime;
	/** 
	 *  @Fields processCreate : 事项处理表创建人
	 * 
	 * */
	private String processCreate;
	/** 
	 *  @Fields processSigntime : 签收时间
	 * 
	 * */
	private java.util.Date processSigntime;
	/** 
	 *  @Fields processHandletime : 处理时间
	 * 
	 * */
	private java.util.Date processHandletime;
	/** 
	 *  @Fields processSigner : 签收人
	 * 
	 * */
	private String processSigner;
	/** 
	 *  @Fields processAuditer : 审核人
	 * 
	 * */
	private String processAuditer;
	/** 
	 *  @Fields attachmentName : 资料名称
	 * 
	 * */
	private String attachmentName;
	/** 
	 *  @Fields attachmentName : 上传时间
	 * 
	 * */
	private java.util.Date attachmentCreatetime;
	/** 
	 *  @Fields attachmentCreate : 上传承办人
	 * 
	 * */
	private String attachmentCreate;
	/** 
	 *  @Fields attachmentFile : 报告名称
	 * 
	 * */
	private String attachmentFile;
	

	private java.util.Date updateTime;//更新时间
	
	private Integer updater;//更新人
	
	private String permanentAddress;//户籍地址
	
	private String createrName;//创建人
	
	private String deptNames;//部门名称
	
	private String xftypeNew;
	
	private String is_law; //是否执法执勤
	
	private Integer source_order;//信访来源排序值
	
	private String work_id;//民生110的工单ID
	
	private Integer iszczb;//是否自存自办
	
	private String xfSourceSub;//子信访来源
	
	private Integer is110qianshou;//民生110是否签收
	
	private String minsheng110source;//民生110信访来源
	
	private String minsheng110comments;//民生110反馈内容
	
	private String hisadv;//民生110历史反馈内容
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private java.util.Date ms110concludeDeadline; //民生110办结期限
	
	private String ms110addcontent;//民生110补充催办内容
	
	private Integer isexport;//是否打印过
	
	private Integer xfYear;//信访显示年份（12月20号以后为新的一年）
	
}

