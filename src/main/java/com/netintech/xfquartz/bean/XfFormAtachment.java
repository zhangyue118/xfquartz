package com.netintech.xfquartz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName:  
 * @Description: 民生110的附件
 * @author administrator
 * @date - 2018年09月20日 12时57分57秒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XfFormAtachment implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;

	/** 
	 *  @Fields Id : id
	 * 
	 * */
	private Long id;
	/** 
	 *  @Fields BusinessNumber : businessNumber
	 * 
	 * */
	private String businessNumber;
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
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date createTime;
	/** 
	 *  @Fields IsFetch : isFetch
	 * 
	 * */
	private Long isFetch;
	
}

