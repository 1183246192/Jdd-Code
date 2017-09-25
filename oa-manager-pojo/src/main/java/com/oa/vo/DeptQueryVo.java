package com.oa.vo;

import java.util.List;

import com.oa.pojo.Department;

public class DeptQueryVo extends Department {

	private String leader;
	private List<Integer> lid;
	
	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public List<Integer> getLid() {
		return lid;
	}

	public void setLid(List<Integer> lid) {
		this.lid = lid;
	}

	
}
