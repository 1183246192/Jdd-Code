package com.e3mall.mapper.vo;

import java.util.List;

import com.e3mall.pojo.vo.ItemQueryVo;


public interface ItemCustomMapper {
	
	//查询item列表
	public List<ItemQueryVo> findItemList(ItemQueryVo itemQueryVo) throws Exception;
	
	//查询总数
	public int findItemCount(ItemQueryVo itemQueryVo) throws Exception;

}
