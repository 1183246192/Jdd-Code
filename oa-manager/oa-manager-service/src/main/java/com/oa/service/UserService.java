package com.oa.service;

import java.util.List;

import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.EasyUITreeNode;
import com.oa.common.pojo.OAResult;
import com.oa.pojo.Department;
import com.oa.pojo.User;

public interface UserService {
	
	EasyUIDataGridResult getUserList(User user,int page, int rows) throws Exception;
	OAResult insertUser(User user) throws Exception;
	User getUserById(int id) throws Exception;
	OAResult updateUser(User user) throws Exception;
	List<Department> getDeptName() throws Exception;
	OAResult deleteUser(Integer id) throws Exception;
	EasyUIDataGridResult getSingleUser(int userid) throws Exception;
	List<User> getAllUsers() throws Exception;
	List<EasyUITreeNode> getTreeByUserId(Integer userid,Integer mid);
	OAResult updateTreeById(Integer userid,String[] ids);
	Department findDeptByDid(Integer did) throws Exception;
}
