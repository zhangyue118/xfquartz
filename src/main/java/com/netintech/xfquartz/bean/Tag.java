package com.netintech.xfquartz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
	private int id;
	private String tag;
	private int matterId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;
	private int creater;

}
