package com.e3mall.service;

import com.e3mall.common.E3Result;
import com.e3mall.common.EasyUIDataGridResult;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.vo.ItemQueryVo;

public interface ItemService {
	TbItem getItembyId(Long itemId) throws Exception;
	EasyUIDataGridResult getItemList(ItemQueryVo itemQueryVo ,int page, int rows) throws Exception;
	E3Result insertItem(TbItem tbItem,String desc) throws Exception;
}
