package com.e3mall.service;

import java.util.List;

import com.e3mall.common.EasyUITreeNode;

public interface ItemCatService {
	List<EasyUITreeNode> getItemCatList(long parentId);
}
