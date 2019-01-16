package com.netintech.xfquartz.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2018年06月26日 18时04分37秒
 */
@Data
public class XfSynAtachment implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : id
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields FormId : formId
	 * 
	 * */
	private String formId;
	/** 
	 *  @Fields MatterId : matterId
	 * 
	 * */
	private Integer matterId;
	/** 
	 *  @Fields Filename : filename
	 * 
	 * */
	private String filename;
	/** 
	 *  @Fields Files : files
	 * 
	 * */
	private byte[] files;
	/** 
	 *  @Fields CreateTime : createTime
	 * 
	 * */
	private Date createTime;
	/**
	 *  @Fields IsHandle : isHandle
	 *
	 * */
	private Integer isHandle;

	public XfSynAtachment(String formId, Integer matterId, String filename, byte[] files, Date createTime, Integer isHandle) {
		this.formId = formId;
		this.matterId = matterId;
		this.filename = filename;
		this.files = files;
		this.createTime = createTime;
		this.isHandle = isHandle;
	}

	public XfSynAtachment() {
	}
}

