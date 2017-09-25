package com.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.mapper.DepartmentMapper;
import com.oa.pojo.Department;
import com.oa.pojo.DepartmentExample;
import com.oa.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService{

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public EasyUIDataGridResult getDepartList(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		DepartmentExample example = new DepartmentExample();
//		Criteria criteria = example.createCriteria();
		List<Department> list = departmentMapper.selectByExample(example);
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
//		int pages = pageInfo.getPages();
//		int pageSize = pageInfo.getPageSize();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(total);
		result.setRows(list);
		return result;
	}
	
	
}
