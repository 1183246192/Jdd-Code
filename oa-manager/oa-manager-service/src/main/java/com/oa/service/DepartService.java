package com.oa.service;

import com.oa.common.pojo.EasyUIDataGridResult;

public interface DepartService {
	
	public EasyUIDataGridResult getDepartList(Integer page,Integer rows);
	
}
