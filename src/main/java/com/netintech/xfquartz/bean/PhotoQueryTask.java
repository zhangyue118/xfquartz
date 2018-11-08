package com.netintech.xfquartz.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:  
 * @Description: test
 * @author administrator
 * @date - 2018年11月06日 10时59分17秒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoQueryTask implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 
	 *  @Fields Id : 流水号
	 * 
	 * */
	private Integer id;
	/** 
	 *  @Fields Taskname : 任务名称
	 * 
	 * */
	private String taskname;
	/** 
	 *  @Fields Excelname : 导入excel文件名
	 * 
	 * */
	private String excelname;
	/** 
	 *  @Fields Tasktime : 任务时间
	 * 
	 * */
	private Date tasktime;
	/** 
	 *  @Fields State : 任务状态（0-任务成功1-任务失败2-任务执行中)
	 * 
	 * */
	private Integer state;
	/** 
	 *  @Fields Adduser : 新建任务用户id
	 * 
	 * */
	private Integer adduser;
	/** 
	 *  @Fields Downloadpath : 下载文件目录
	 * 
	 * */
	private String downloadpath;

}

