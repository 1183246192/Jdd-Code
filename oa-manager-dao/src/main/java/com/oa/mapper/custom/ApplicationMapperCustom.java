package com.oa.mapper.custom;

import java.util.List;

import com.oa.pojo.Application;


public interface ApplicationMapperCustom {
	List<Application> findApplicationByleaderid(Integer leaserid);
	int insertappAndGetId(Application application);
}