package com.e3mall.content.service;

import java.util.List;

import com.e3mall.common.E3Result;
import com.e3mall.common.EasyUIDataGridResult;
import com.e3mall.common.EasyUITreeNode;

public interface ContentCategoryService {

	public List<EasyUITreeNode> getContentCategoryList(long parentId);
	public E3Result addContentCategory(long parentId,String name);
	public E3Result updateContentCategory(long id,String name);
	public E3Result deleteContentCategory(long id);
	public EasyUIDataGridResult getContentList(Long categoryId, int page, int rows) ;
}
