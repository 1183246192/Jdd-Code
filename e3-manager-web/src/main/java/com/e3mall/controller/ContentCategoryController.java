package com.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.common.E3Result;
import com.e3mall.common.EasyUIDataGridResult;
import com.e3mall.common.EasyUITreeNode;
import com.e3mall.content.service.ContentCategoryService;


@Controller
@RequestMapping("/content")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(
			@RequestParam(value="id", defaultValue="0") Long parentId) {
		
		List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
		return list;
	}

	@RequestMapping("/category/create")
	@ResponseBody
	public E3Result createContentCategory(long parentId,String name) {
		E3Result result = contentCategoryService.addContentCategory(parentId, name);
		return result;
	}
	//content/category/update
	@RequestMapping("/category/update")
	@ResponseBody
	public E3Result updateContentCategory(long id,String name) {
		E3Result result = contentCategoryService.updateContentCategory(id, name);
		return result;
	}
	
	@RequestMapping("/category/delete")
	@ResponseBody
	public E3Result deleteContentCategory(long id) {
		E3Result result = contentCategoryService.deleteContentCategory(id);
		return result;
	}
	
	///content/query/list
	@RequestMapping("/query/list")
	@ResponseBody
	public EasyUIDataGridResult getContentList(Long categoryId, int page, int rows) {
		EasyUIDataGridResult result = contentCategoryService.getContentList(categoryId, page, rows);
		return result;
	}
}
