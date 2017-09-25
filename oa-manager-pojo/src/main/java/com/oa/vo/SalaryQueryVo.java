package com.oa.vo;

import com.oa.pojo.Salary;

public class SalaryQueryVo extends Salary {
	
	private String name;
	private String deptName;
	private Integer did;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	
}
