package com.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.EasyUITreeNode;
import com.oa.common.pojo.OAResult;
import com.oa.common.utils.ExceptionResultInfo;
import com.oa.common.utils.ResultInfo;
import com.oa.mapper.DepartmentMapper;
import com.oa.mapper.MenusMapper;
import com.oa.mapper.UserMapper;
import com.oa.mapper.UserpermissionMapper;
import com.oa.mapper.custom.UserMapperCustom;
import com.oa.pojo.Department;
import com.oa.pojo.DepartmentExample;
import com.oa.pojo.Menus;
import com.oa.pojo.MenusExample;
import com.oa.pojo.User;
import com.oa.pojo.UserExample;
import com.oa.pojo.Userpermission;
import com.oa.pojo.UserpermissionExample;
import com.oa.pojo.UserExample.Criteria;
import com.oa.service.UserService;
import com.oa.vo.UserQueryVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserMapperCustom userMapperCustom;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private MenusMapper menusMapper;
	
	@Autowired
	private UserpermissionMapper permissionMapper;
	
	@Override
	public EasyUIDataGridResult getUserList(User user,int page, int rows) throws Exception {
		PageHelper.startPage(page, rows);
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (user.getUsername() != null && user.getUsername() != "") {
			criteria.andUsernameLike("%"+user.getUsername()+"%");
		}
		if (user.getPhone() != null && user.getPhone() != "") {
			criteria.andPhoneLike("%"+user.getPhone()+"%");
		}
		if (user.getTelephone() != null && user.getTelephone() != "") {
			criteria.andTelephoneLike("%"+user.getTelephone()+"%");
		}
		if (user.getEmail() != null && user.getEmail() != "") {
			criteria.andEmailLike("%"+user.getEmail()+"%");
		}
		
//		UserCustom userCustom = new UserCustom();
//		userCustom.setPage(page);
//		userCustom.setRows(rows);
//		List<User> list = userMapperCustom.findSysuserList(userCustom);
		List<User> list = userMapper.selectByExample(example);
		List<UserQueryVo> listvo = new ArrayList<UserQueryVo>();
		for (User user2 : list) {
			UserQueryVo userQueryVo = new UserQueryVo();
			BeanUtils.copyProperties(user2, userQueryVo);
			Integer did = user2.getDid();
			Department department = departmentMapper.selectByPrimaryKey(did);
			String name = department.getName();
			userQueryVo.setDeptName(name);
			listvo.add(userQueryVo);
		}
		PageInfo<User> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
//		int pages = pageInfo.getPages();
//		int pageSize = pageInfo.getPageSize();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(total);
		result.setRows(listvo);
		return result;
	}

	@Override
	public OAResult insertUser(User user) throws Exception {
		String username = user.getUsername();
		List<User> list = userMapperCustom.findUserByName(username);
		if (list != null && list.size() > 0 ) {
			ResultInfo resultInfo = new ResultInfo(500, "用户已存在！", null);
			throw new ExceptionResultInfo(resultInfo);
//			return OAResult.build(500, "用户已存在！");
		}
		user.setStatus(1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date date = new Date();
		String str=sdf.format(date);  
		user.setCreatedate(str);
		user.setIsleader(0); 		//0不是部门领导，1是部门领导
		userMapper.insert(user);
		return OAResult.build(200, "新增用户成功!");
	}

	@Override
	public User getUserById(int id) throws Exception {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public OAResult updateUser(User user) throws Exception {
		User user2 = userMapper.selectByPrimaryKey(user.getId());
		user.setCreatedate(user2.getCreatedate());
		user.setStatus(user2.getStatus());
		userMapper.updateByPrimaryKey(user);
		return OAResult.build(200, "修改用户信息成功！");
	}

	@Override
	public List<Department> getDeptName() throws Exception {
		DepartmentExample example = new DepartmentExample();
		List<Department> list = departmentMapper.selectByExample(example);
		return list;
	}

	@Override
	public OAResult deleteUser(Integer id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
		return OAResult.build(200, "删除用户成功！");
	}

	@Override
	public EasyUIDataGridResult getSingleUser(int userid) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(userid);
		List<User> list = userMapper.selectByExample(example);
		List<UserQueryVo> listvo = new ArrayList<UserQueryVo>();
		if (list != null && list.size() > 0 ) {
			for (User user2 : list) {
				UserQueryVo userQueryVo = new UserQueryVo();
				BeanUtils.copyProperties(user2, userQueryVo);
				Integer did = user2.getDid();
				Department department = departmentMapper.selectByPrimaryKey(did);
				String name = department.getName();
				userQueryVo.setDeptName(name);
				listvo.add(userQueryVo);
			}
			PageInfo<User> pageInfo = new PageInfo<>(list);
			long total = pageInfo.getTotal();
//			int pages = pageInfo.getPages();
//			int pageSize = pageInfo.getPageSize();
			EasyUIDataGridResult result = new EasyUIDataGridResult();
			result.setTotal(total);
			result.setRows(listvo);
			return result;
		}
		ResultInfo resultInfo = new ResultInfo(500, "未知错误，请联系管理员！", null);
		throw new ExceptionResultInfo(resultInfo);
	}

	@Override
	public List<User> getAllUsers() throws Exception {
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<EasyUITreeNode> getTreeByUserId(Integer user_id,Integer m_id) {
		MenusExample example = new MenusExample();
		com.oa.pojo.MenusExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(m_id);
		List<Menus> list = menusMapper.selectByExample(example);//根据id加载菜单
		List<EasyUITreeNode> nodeList = new ArrayList<EasyUITreeNode>();
		
		UserpermissionExample per = new UserpermissionExample();//根据userid加载权限
		com.oa.pojo.UserpermissionExample.Criteria criteria3 = per.createCriteria();
		criteria3.andUseridEqualTo(user_id);
		List<Userpermission> perList = permissionMapper.selectByExample(per);
		Userpermission userpermission = perList.get(0);
		String group1 = userpermission.getGroup1();
		String group2 = userpermission.getGroup2();
		String group3 = userpermission.getGroup3();
		String group4 = userpermission.getGroup4();
		String group5 = userpermission.getGroup5();
		String str = null;
		for (int i = 0; i < list.size(); i++) {
			Menus menus = list.get(i);
			String menuid = menus.getMenuid();
			String menu_id = menuid.substring(0,1);		//根据menuid确定是属于哪个group
			int group_id = Integer.parseInt(menu_id);
			
			if (group_id == 1) {str = group1;}else if (group_id == 2) {str = group2;}else if (group_id == 3) {str = group3;
			}else if (group_id == 4) {str = group4;}else if (group_id == 5) {str = group5;}
			String groid = null;
			if (menus.getIsParent() == 1) {
				groid = str.substring(0,1);//截取permission表的group第一位
			}else {
				groid = str.substring(i+1,i+2);//截取permission表的group第一位之后的权限
				/*if (groid.equals("0")) {
					continue;
				}*/
			}
			
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(menus.getId());
			node.setText(menus.getMenuname());
			node.setState(menus.getIsParent() == 0 ? "open" : "closed");
			node.setIconCls(null);
			if (groid.equals("1") && menus.getIsParent() == 0) {
				node.setChecked("checked");
			}
			nodeList.add(node);
		}
		
		return nodeList;
	}

	@Override
	public OAResult updateTreeById(Integer userid, String[] ids) {
		UserpermissionExample per = new UserpermissionExample();//根据userid加载权限
		com.oa.pojo.UserpermissionExample.Criteria criteria = per.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Userpermission> perList = permissionMapper.selectByExample(per);
		Userpermission userpermission = perList.get(0);
		String group1 = userpermission.getGroup1();
		String group2 = userpermission.getGroup2();
		String group3 = userpermission.getGroup3();
		String group4 = userpermission.getGroup4();
		String group5 = userpermission.getGroup5();
		String str = null;
		StringBuffer g_value = new StringBuffer();
		String g_value1 = null;
		String g_value2 = null;
		String g_value3 = null;
		String g_value4 = null;
		String g_value5 = null;
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			Menus menus = menusMapper.selectByPrimaryKey(Integer.parseInt(id));
			String menuid = menus.getMenuid();			
			String menu_id = menuid.substring(0,1);		//根据menuid确定是属于哪个group
			int group_id = Integer.parseInt(menu_id);
			
			Integer isParent = menus.getIsParent();
			if (isParent == 1) {						//判断父节点是否选定
				g_value.delete(0, g_value.length());
				g_value.append("1");
				continue;
			}
			int g_mid = Integer.parseInt(menuid.substring(2,3));//表示当前的menu是第几个
			String temp = null ;
			if (group_id == 1) {
				temp = g_value1;
			}else if (group_id == 2) {
				temp = g_value2;
			}else if (group_id == 3) {
				temp = g_value3;
			}else if (group_id == 4) {
				temp = g_value4;
			}else if (group_id == 5) {
				temp = g_value5;
			}
			int length = g_value.length();
			if (length > 0 && temp == null) {
				g_value.delete(0, g_value.length());
				g_value.append("1");
				for (int j = 1; j < g_mid; j++) {
					g_value.append("0");
				}
			}
			for (int j = g_mid; j < 6; j++) {
//				String g_id = str.substring(j,j+1);
				if (g_mid == j) {
					g_value.append("1");
					continue;
				}else{
					for (int k = length; k < g_mid+1; k++) {
						g_value.append("0");
					}
					continue;
				}
			}
			if (group_id == 1) {
				g_value1 = g_value.toString(); 
			}else if (group_id == 2) {
				g_value2 = g_value.toString();
			}else if (group_id == 3) {
				g_value3 = g_value.toString();
			}else if (group_id == 4) {
				g_value4 = g_value.toString();
			}else if (group_id == 5) {
				g_value5 = g_value.toString();
			}
			
		}
		Userpermission record = permissionMapper.selectByPrimaryKey(userid);
		record.setGroup1(g_value1 == null ? null : g_value1.toString());
		record.setGroup2(g_value2 == null ? null : g_value2.toString());
		record.setGroup3(g_value3 == null ? null : g_value3.toString());
		record.setGroup4(g_value4 == null ? null : g_value4.toString());
		record.setGroup5(g_value5 == null ? null : g_value5.toString());
		permissionMapper.updateByPrimaryKeySelective(record);
		return OAResult.ok();
	}

	@Override
	public Department findDeptByDid(Integer did) throws Exception {
		Department department = departmentMapper.selectByPrimaryKey(did);
		return department;
	}

}
