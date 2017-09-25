package com.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.common.E3Result;
import com.e3mall.common.EasyUIDataGridResult;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.vo.ItemQueryVo;
import com.e3mall.service.ItemService;



@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem getItembyId(@PathVariable Long itemId) throws Exception{
		TbItem item = itemService.getItembyId(itemId);
		return item;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(ItemQueryVo itemQueryVo,int page,int rows) throws Exception {
		EasyUIDataGridResult itemList = itemService.getItemList(itemQueryVo,page, rows);
		return itemList;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public E3Result saveItem(TbItem item, String desc) throws Exception {
		E3Result result = itemService.insertItem(item, desc);
		return result;
	}

	
}
