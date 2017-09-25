package com.oa.mapper.custom;

import java.util.List;

import com.oa.pojo.Department;
import com.oa.pojo.User;
import com.oa.vo.DeptQueryVo;


public interface DeptMapperCustom {
	List<DeptQueryVo> findDeptQueryVoList(Department department);
	List<User> findUserByDid(int did);
}