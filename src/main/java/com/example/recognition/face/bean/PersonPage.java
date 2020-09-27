package com.example.recognition.face.bean;

public class PersonPage {
	
	private Integer total;
	private Integer pageSize;
	private Integer pageNo;
	private java.util.List<Person> list;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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

	public java.util.List<Person> getList() {
		return list;
	}

	public void setList(java.util.List<Person> list) {
		this.list = list;
	}

}
