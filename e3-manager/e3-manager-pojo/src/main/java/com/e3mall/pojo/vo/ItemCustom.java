package com.e3mall.pojo.vo;

import java.io.Serializable;

import com.e3mall.pojo.TbItem;

public class ItemCustom extends TbItem implements Serializable{

	private String protitle ;
	private String propoint ;
	private String proprice1 ;
	private String proprice2 ;
	public String getProtitle() {
		return protitle;
	}
	public void setProtitle(String protitle) {
		this.protitle = protitle;
	}
	public String getPropoint() {
		return propoint;
	}
	public void setPropoint(String propoint) {
		this.propoint = propoint;
	}
	public String getProprice1() {
		return proprice1;
	}
	public void setProprice1(String proprice1) {
		this.proprice1 = proprice1;
	}
	public String getProprice2() {
		return proprice2;
	}
	public void setProprice2(String proprice2) {
		this.proprice2 = proprice2;
	}
	
}
