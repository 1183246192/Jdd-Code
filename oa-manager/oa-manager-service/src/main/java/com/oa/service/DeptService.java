package com.oa.service;

import java.util.List;

import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.OAResult;
import com.oa.pojo.Department;
import com.oa.pojo.User;
import com.oa.vo.DeptQueryVo;

public interface DeptService {
	
	EasyUIDataGridResult getDepartList(DeptQueryVo deptQueryVo,Integer page,Integer rows) throws Exception;
	Department getDeptById(int id) throws Exception;
	OAResult insertDept(DeptQueryVo deptQueryVo) throws Exception;
	OAResult updateDept(DeptQueryVo deptQueryVo) throws Exception;
	List<User> findDept_user() throws Exception;
	String findDept_user(int did) throws Exception;
	List<User> findUserByDid(int did) throws Exception;
	OAResult updateLeader(DeptQueryVo deptQueryVo) throws Exception;
}
