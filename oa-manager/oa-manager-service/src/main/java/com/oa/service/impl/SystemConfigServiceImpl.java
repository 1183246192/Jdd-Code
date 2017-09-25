package com.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.mapper.BasicinfoMapper;
import com.oa.pojo.Basicinfo;
import com.oa.service.SystemConfigService;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {

	@Autowired
	private BasicinfoMapper basicinfoMapper;
	
	@Override
	public String findBasicinfoById(String id) throws Exception {
		Basicinfo basicinfo = basicinfoMapper.selectByPrimaryKey(id);
		String value = basicinfo.getValue();
		return value;
	}

}
