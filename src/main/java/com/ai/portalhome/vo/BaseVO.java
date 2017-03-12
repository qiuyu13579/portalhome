package com.ai.portalhome.vo;

import java.io.Serializable;

public class BaseVO  implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private Integer pageNo = 1;// 请求查询的页码

	private Integer pageSize = 10;// 每页显示条数
	

	public BaseVO() {
		
	}


	/**
	 * 获取开始行
	 * 
	 * @return int
	 */
	public int getStartRowIndex() {
		return (this.getPageNo() - 1) * this.getPageSize() + 1;
	}

	/**
	 * 获取结束行
	 * 
	 * @return int
	 */
	public int getEndRowIndex() {
		return this.getPageNo() * this.getPageSize();
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}


}