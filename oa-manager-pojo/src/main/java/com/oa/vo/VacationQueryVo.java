package com.oa.vo;

import com.oa.pojo.Annualvacation;

public class VacationQueryVo extends Annualvacation {

	private String name;
	private String deptName;
	private Integer did;
	private String statime ;//starttime
	private String stotime ;//stoptime
	private String pretime ;//previousstoptime
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
	public String getStatime() {
		return statime;
	}
	public void setStatime(String statime) {
		this.statime = statime;
	}
	public String getStotime() {
		return stotime;
	}
	public void setStotime(String stotime) {
		this.stotime = stotime;
	}
	public String getPretime() {
		return pretime;
	}
	public void setPretime(String pretime) {
		this.pretime = pretime;
	}
	
	
}
