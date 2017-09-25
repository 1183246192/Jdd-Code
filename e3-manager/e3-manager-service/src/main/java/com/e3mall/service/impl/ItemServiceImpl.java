package com.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.E3Result;
import com.e3mall.common.EasyUIDataGridResult;
import com.e3mall.mapper.TbItemDescMapper;
import com.e3mall.mapper.TbItemMapper;
import com.e3mall.mapper.vo.ItemCustomMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemDesc;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.pojo.vo.ItemQueryVo;
import com.e3mall.pojo.vo.PageQuery;
import com.e3mall.service.ItemService;
import com.e3mall.utils.IDUtils;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Autowired
	private ItemCustomMapper ItemCustomMapper;
	
	@Override
	public TbItem getItembyId(Long itemId) {
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public EasyUIDataGridResult getItemList(ItemQueryVo itemQueryVo,int page, int rows) throws Exception {
		//TODO
		itemQueryVo = itemQueryVo == null ? new ItemQueryVo():itemQueryVo;
		//查询总数
		int total = ItemCustomMapper.findItemCount(itemQueryVo);
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(total, rows, page);
		itemQueryVo.setPageQuery(pageQuery);
		//查询带有分页结果的总数
		List<ItemQueryVo> list = ItemCustomMapper.findItemList(itemQueryVo);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(total);
		return result;
//		PageHelper.startPage(page, rows);
//		TbItemExample example = new TbItemExample();
//		List<TbItem> list = tbItemMapper.selectByExample(example);
//		EasyUIDataGridResult result = new EasyUIDataGridResult();
//		result.setRows(list);
//		PageInfo<TbItem> info = new PageInfo<TbItem>(list);
//		result.setTotal(info.getTotal());
//		return result;
	}

	@Override
	public E3Result insertItem(TbItem item, String desc) {
		// 1、生成商品id
		long itemId = IDUtils.genItemId();
		// 2、补全TbItem对象的属性
		item.setId(itemId);
		// 商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		// 3、向商品表插入数据
		tbItemMapper.insert(item);
		// 4、创建一个TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		// 5、补全TbItemDesc的属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		// 6、向商品描述表插入数据
		itemDescMapper.insert(itemDesc);
		// 7、E3Result.ok()
		return E3Result.ok();

	}

}
