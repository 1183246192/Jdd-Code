package com.oa.common.pojo;

import java.util.List;

public class EasyUIMenu {
//"icon" : "icon-sys","menuid" : "1","menuname" : "部门管理","url" : "","menus"
//	private int id;
	

	private String icon;
	private String menuid;
	private String menuname;
	private String url;
	private List<?> menus;
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url == null ? "" : url;
	}
	
	
/*	private MenuItem menuItem;
	
	public MenuItem getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	*/
	
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	
	public List<?> getMenus() {
		return menus;
	}
	public void setMenus(List<?> menus) {
		this.menus = menus;
	}
	
}
