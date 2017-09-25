package com.oa.vo;

import com.oa.pojo.Application;

public class ApplicationQueryVo extends Application {
	private String name;		//姓名
	private String deptName;	//部门名
	private Integer did;		//部门id
	private String apptime;		//对应的applytime
	private Integer spStatus;	//审批状态
	private String opinion;		//审批意见
//	private String leaderlist;	//所有领导的ID
	private String schedule;	//审核进度
	private String sp_result;	//审批结果
	private String sp_opinion;	//审批意见
	
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

	public String getApptime() {
		return apptime;
	}

	public void setApptime(String apptime) {
		this.apptime = apptime;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Integer getSpStatus() {
		return spStatus;
	}

	public void setSpStatus(Integer spStatus) {
		this.spStatus = spStatus;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getSp_result() {
		return sp_result;
	}

	public void setSp_result(String sp_result) {
		this.sp_result = sp_result;
	}

	public String getSp_opinion() {
		return sp_opinion;
	}

	public void setSp_opinion(String sp_opinion) {
		this.sp_opinion = sp_opinion;
	}

}
