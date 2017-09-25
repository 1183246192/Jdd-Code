package com.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.EasyUITreeNode;
import com.e3mall.mapper.TbItemCatMapper;
import com.e3mall.pojo.TbItemCat;
import com.e3mall.pojo.TbItemCatExample;
import com.e3mall.pojo.TbItemCatExample.Criteria;
import com.e3mall.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return null;
		}
		List<EasyUITreeNode> nodeList = new ArrayList<EasyUITreeNode>();
		for (int i = 0; i < list.size(); i++) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(list.get(i).getId());
			node.setState(list.get(i).getIsParent()?"closed":"open");
			node.setText(list.get(i).getName());
			nodeList.add(node);
		}
		return nodeList;
	}

}
