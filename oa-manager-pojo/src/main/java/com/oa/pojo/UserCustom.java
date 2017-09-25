package com.oa.pojo;

public class UserCustom {
    //当前页码
	int page;
	//当前页记录数
	int rows;
	// 总记录数
	int pageSize;
	// 总记录数
	int infoCounts;
	User user;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getInfoCounts() {
		return infoCounts;
	}
	public void setInfoCounts(int infoCounts) {
		this.infoCounts = infoCounts;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}