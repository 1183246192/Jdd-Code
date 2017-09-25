package com.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.E3Result;
import com.e3mall.common.EasyUIDataGridResult;
import com.e3mall.common.EasyUITreeNode;
import com.e3mall.content.service.ContentCategoryService;
import com.e3mall.mapper.TbContentCategoryMapper;
import com.e3mall.mapper.TbContentMapper;
import com.e3mall.pojo.TbContent;
import com.e3mall.pojo.TbContentCategory;
import com.e3mall.pojo.TbContentCategoryExample;
import com.e3mall.pojo.TbContentCategoryExample.Criteria;
import com.e3mall.pojo.TbContentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;
	@Autowired
	private TbContentMapper tbContentMapper;
	
	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> catList = tbContentCategoryMapper.selectByExample(example);
		List<EasyUITreeNode> nodeList = new ArrayList<EasyUITreeNode>();
		for (TbContentCategory tbContentCategory : catList) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			nodeList.add(node);
		}
		
		return nodeList;
	}

	@Override
	public E3Result addContentCategory(long parentId, String name) {
		TbContentCategory record = new TbContentCategory();
		record.setParentId(parentId);
		record.setName(name);
		record.setStatus(1);
		record.setSortOrder(1);
		record.setIsParent(false);
		record.setCreated(new Date());
		record.setUpdated(new Date());
		tbContentCategoryMapper.insert(record);
		//判断父节点是否为叶子结点
		TbContentCategory category = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		if (!(category.getIsParent())) {
			category.setIsParent(true);
			tbContentCategoryMapper.updateByPrimaryKey(category);
		}
		return E3Result.ok(record);
	}

	@Override
	public E3Result updateContentCategory(long id, String name) {
		TbContentCategory contentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);
		contentCategory.setName(name);
		tbContentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
		return E3Result.ok();
	}

	@Override
	public E3Result deleteContentCategory(long id) {
		//查询是否有父节点为这个ID的数据
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
		if (list.size() > 0 && list != null) {
			return E3Result.build(500, "不是叶子结点");
		}
		tbContentCategoryMapper.deleteByPrimaryKey(id);
		return E3Result.ok();
	}

	@Override
	public EasyUIDataGridResult getContentList(Long categoryId, int page, int rows) {
		PageHelper.startPage(page, rows);     //分页核心代码
		TbContentExample example = new TbContentExample();
		com.e3mall.pojo.TbContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = tbContentMapper.selectByExample(example);
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
		long total = pageInfo.getTotal();     //获取分页总数
		int pages = pageInfo.getPages();      //获取分页第N页
		int pageSize = pageInfo.getPageSize();  //每页M条记录数
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(total);
		return result;
	}

}
