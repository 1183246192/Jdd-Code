package com.oa.service;

import java.util.Map;

import com.oa.common.pojo.OAResult;
import com.oa.pojo.User;
import com.oa.vo.ActiveUser;


public interface LoginService {
	
	ActiveUser findUserByuserandpass(String username,String password);
	User findUserByUserid(int userid);
	OAResult updateUserPass(User user);
	Map getMenuList(Integer parentId,Integer userid);
}
