package com.oa.mapper.custom;

import java.util.List;

import com.oa.pojo.Department;
import com.oa.pojo.User;


public interface UserMapperCustom {
	List<User> findUserByName(String username);
	User findUserById(Integer id);
	Department findDeptNameById(Integer id);
	List<User> findUseridByName(String username);
	List<User> findUseridByDeptid(Integer id);
}