package com.oa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.common.pojo.EasyUIMenu;
import com.oa.common.pojo.MenuItem;
import com.oa.common.pojo.OAResult;
import com.oa.mapper.MenusMapper;
import com.oa.mapper.UserMapper;
import com.oa.mapper.UserpermissionMapper;
import com.oa.pojo.Menus;
import com.oa.pojo.MenusExample;
import com.oa.pojo.User;
import com.oa.pojo.UserExample;
import com.oa.pojo.UserExample.Criteria;
import com.oa.pojo.Userpermission;
import com.oa.pojo.UserpermissionExample;
import com.oa.service.LoginService;
import com.oa.vo.ActiveUser;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MenusMapper menusMapper;
	
	@Autowired
	private UserpermissionMapper permissionMapper;
	
	@Override
	public ActiveUser findUserByuserandpass(String username, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		if (list != null && list.size() >0) {
			User user = list.get(0);
			ActiveUser activeUser = new ActiveUser();
			activeUser.setUserid(user.getId());
			activeUser.setIsleader(user.getIsleader());
			activeUser.setUsername(user.getUsername());
			activeUser.setDid(user.getDid());
			return activeUser;
		}
		return null;
	}

	@Override
	public User findUserByUserid(int userid) {
		User user = userMapper.selectByPrimaryKey(userid);
		return user;
	}

	@Override
	public OAResult updateUserPass(User user) {
		userMapper.updateByPrimaryKeySelective(user);
		return OAResult.ok();
	}

	@Override
	public Map getMenuList(Integer parentId,Integer userid) {
		MenusExample example = new MenusExample();
		com.oa.pojo.MenusExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<Menus> list = menusMapper.selectByExample(example); //所有parentid为0的父节点
		List<EasyUIMenu> listms = new ArrayList<EasyUIMenu>();
		for (int i = 0; i < list.size(); i++) {
			Menus menus1 = list.get(i);
			UserpermissionExample per = new UserpermissionExample();
			com.oa.pojo.UserpermissionExample.Criteria criteria3 = per.createCriteria();
			criteria3.andUseridEqualTo(userid);
			List<Userpermission> perList = permissionMapper.selectByExample(per);
			Userpermission userpermission = perList.get(0);
			Integer isadmin = userpermission.getIsadmin();
			String group1 = userpermission.getGroup1();
			String group2 = userpermission.getGroup2();
			String group3 = userpermission.getGroup3();
			String group4 = userpermission.getGroup4();
			String group5 = userpermission.getGroup5();
			String str = "111111";
			String menuid = menus1.getMenuid();				//获取menuid:  3_1
			if (isadmin == 0) {
				String menu_id = menuid.substring(0,1);		//根据menuid确定是属于哪个group
				int group_id = Integer.parseInt(menu_id);
				
				if (group_id == 1) {str = group1;}else if (group_id == 2) {str = group2;}else if (group_id == 3) {str = group3;
				}else if (group_id == 4) {str = group4;}else if (group_id == 5) {str = group5;}
//				String groid = str.substring(i+1,i+2);//截取permission表的group第一位
				
				String groid = str.substring(0,1);//截取permission表的group第一位
//				int gid = Integer.parseInt(groid);
				if (groid.equals("0")) {
					continue;
				}
			}
			Integer isParent = menus1.getIsParent();
			String icon = menus1.getIcon();
//			String menuid = menus1.getMenuid();
			String menuname = menus1.getMenuname();
			String url = menus1.getUrl();
			Integer id = menus1.getId();
			MenusExample ex = new MenusExample();
			com.oa.pojo.MenusExample.Criteria criteria2 = ex.createCriteria();
			criteria2.andParentIdEqualTo(id);
			List<Menus> list2 = menusMapper.selectByExample(ex);
			
			List<MenuItem> listMenus = new ArrayList<MenuItem>();
			String pid = str.substring(1);	//截取permission表的group第二位之后的数据
			for (int j = 0; j < list2.size(); j++) {
				String sub = pid.substring(j, j+1);	//截取当前的权限
				if (sub.equals("0")) {
					continue;
				}
				Menus menus2 = list2.get(j);
				MenuItem menu = new MenuItem();
				menu.setIcon(menus2.getIcon());
				menu.setMenuid(menus2.getMenuid());
				menu.setMenuname(menus2.getMenuname());
				menu.setUrl(menus2.getUrl());
				listMenus.add(menu);
			}
			EasyUIMenu mus = new EasyUIMenu();
			mus.setMenus(listMenus);
			mus.setIcon(icon);
			mus.setMenuid(menuid);
			mus.setMenuname(menuname);
			mus.setUrl(url);
			listms.add(mus);
		}
		Map<String, List<EasyUIMenu>> map = new HashMap<String, List<EasyUIMenu>>();
		map.put("menus", listms);
		return map;
	}


}
