package com.oa.vo;


/**
 * 用户身份信息，存入session
 * 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 *
 */
public class ActiveUser  implements java.io.Serializable {
	private int userid;//用户账号
	private String username;//用户名称
	private Integer did;
	private Integer isleader;
	private String groupid;//用户类型
	private String groupname;//用户类型名称
	
//	private Menu menu;//操作菜单
//	private List<Operation> operationList;//操作权限，包括用户点击菜单及操作菜单功能所有链接权限
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Integer getIsleader() {
		return isleader;
	}
	public void setIsleader(Integer isleader) {
		this.isleader = isleader;
	}


}
