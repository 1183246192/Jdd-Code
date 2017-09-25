package com.e3mall.pojo.vo;

import java.io.Serializable;


public class ItemQueryVo implements Serializable{

	private PageQuery pageQuery;
	private ItemCustom itemCustom;
	
	public PageQuery getPageQuery() {
		return pageQuery;
	}
	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}
	public ItemCustom getItemCustom() {
		return itemCustom;
	}
	public void setItemCustom(ItemCustom itemCustom) {
		this.itemCustom = itemCustom;
	}
	
}
