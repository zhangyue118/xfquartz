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
 * @date - 2018年03月22日 14时09分53秒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XfAttachment implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
	/**
	 *  @Fields Id : 唯一标识
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields Type : F表示法律文书，X表示相关资料，Z表示佐证资料,C表示承办资料。
	 * 
	 * */
	private String type;
	/** 
	 *  @Fields File : 文件名，如: /upload/xx.doc
	 * 
	 * */
	private String file;
	/** 
	 *  @Fields FileSize : 文件大小,如1M , 2K
	 * 
	 * */
	private String fileSize;
	/** 
	 *  @Fields Extension : 文件名后缀 如jpg
	 * 
	 * */
	private String extension;
	/** 
	 *  @Fields Name : 文档名称，规则：类型+yyyyMMdd+2位序号+上传的文件名，序号规则是在同一事项，同一类型资料的最大序号+1，不足高位补0
	 * 
	 * */
	private String name;
	/** 
	 *  @Fields MatterId : 事项ID
	 * 
	 * */
	private Integer matterId;
	/** 
	 *  @Fields ProcessId : 事项处理表ID
	 * 
	 * */
	private Integer processId;
	/** 
	 *  @Fields UndertakeId : 事项承办表ID
	 * 
	 * */
	private Integer undertakeId;
	/** 
	 *  @Fields CreateTime : 创建时间
	 * 
	 * */
	private Date createTime;
	/**
	 *  @Fields Creater : 创建者
	 *
	 * */
	private Integer creater;
	/**
	 *  @Fields UpdateTime : 更新时间
	 *
	 * */
	private Date updateTime;
	/**
	 *  @Fields Updater : 更新者
	 *
	 * */
	private Integer updater;
	/**
	 *  @Fields Updater : 承办单位名称
	 *
	 * */
	private String undertakeName;
	/**
	 *  @Fields Updater : 创建者名称
	 *
	 * */
	private String createrStr;

	/**
	 *  @Fields librarycode : 文书编码
	 *
	 * */
	private String librarycode;

}

