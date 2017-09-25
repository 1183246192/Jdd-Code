package com.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.OAResult;
import com.oa.mapper.DepartmentMapper;
import com.oa.mapper.UserMapper;
import com.oa.mapper.custom.DeptMapperCustom;
import com.oa.pojo.Department;
import com.oa.pojo.DepartmentExample;
import com.oa.pojo.DepartmentExample.Criteria;
import com.oa.pojo.User;
import com.oa.pojo.UserExample;
import com.oa.service.DeptService;
import com.oa.vo.DeptQueryVo;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired 
	private UserMapper userMapper;
	
	@Autowired
	private DeptMapperCustom deptMapperCustom;

	@Override
	public EasyUIDataGridResult getDepartList(DeptQueryVo deptQueryVo, Integer page, Integer rows) throws Exception {
		PageHelper.startPage(page, rows);
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		if (deptQueryVo.getName() != null && deptQueryVo.getName() !="") {
			criteria.andNameLike("%"+deptQueryVo.getName()+"%");
		}
		
		List<Department> list = departmentMapper.selectByExample(example);
		
		List<DeptQueryVo> listQuery = new ArrayList<DeptQueryVo>();
		for (Department department2 : list) {
			Integer id = department2.getId();
			UserExample example2 = new UserExample();
			com.oa.pojo.UserExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andDidEqualTo(id);
			criteria2.andIsleaderEqualTo(1);
			List<User> list2 = userMapper.selectByExample(example2);
			DeptQueryVo dpo = new DeptQueryVo();
			if (list2 != null && list2.size() >0 ) {
				String Lname = "";
				if (list2.size() > 1) {
					for (User user : list2) {
						Lname = Lname + user.getUsername() + ",";
					}
					Lname = Lname.substring(0, Lname.length()-1);
				}else {
					for (User user : list2) {
						Lname = Lname + user.getUsername();
					}
				}
				
				dpo.setLeader(Lname);
			}
			dpo.setId(department2.getId());
			dpo.setName(department2.getName());
			dpo.setDescription(department2.getDescription());
			dpo.setStatus(department2.getStatus());
			dpo.setCreatedate(department2.getCreatedate());
			listQuery.add(dpo);
		}
		PageInfo<Department> pageInfo = new PageInfo<Department>(list);
		long total = pageInfo.getTotal();
//		int pages = pageInfo.getPages();
//		int pageSize = pageInfo.getPageSize();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(total);
		result.setRows(listQuery);
		return result;
	}	

	@Override
	public Department getDeptById(int id) throws Exception {
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<Department> list = departmentMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public OAResult insertDept(DeptQueryVo deptQueryVo) throws Exception {
		/*
		UserExample example = new UserExample();
		com.oa.pojo.UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(deptQueryVo.getLeader());
		List<User> list = userMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			Integer deptId = deptQueryVo.getId();
			UserExample example2 = new UserExample();
			com.oa.pojo.UserExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andDidEqualTo(deptId);
			List<User> list2 = userMapper.selectByExample(example2);
			if (list2 != null && list2.size() > 0) {
				User record = new User();
				record.setIsleader(0);
				userMapper.updateByPrimaryKeySelective(record);//只是更新新的model中不为空的字段
			}
			User record = new User();
			record.setIsleader(1);//0不是部门领导，1是部门领导
			userMapper.updateByPrimaryKeySelective(record);
		}*/
		Department d_record = new Department();
		d_record.setName(deptQueryVo.getName());
		d_record.setDescription(deptQueryVo.getDescription());
		d_record.setStatus(1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date date = new Date();
		String str=sdf.format(date);  
		d_record.setCreatedate(str);
		
		departmentMapper.insert(d_record);
		return OAResult.ok();
	}

	@Override
	public OAResult updateDept(DeptQueryVo deptQueryVo) throws Exception {
		Department department2 = departmentMapper.selectByPrimaryKey(deptQueryVo.getId());
		department2.setDescription(deptQueryVo.getDescription());
		department2.setName(deptQueryVo.getName());
		departmentMapper.updateByPrimaryKeySelective(department2);
		
		/*通过姓名查user对象s
		UserExample example = new UserExample();
		com.oa.pojo.UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(deptQueryVo.getLeader());
		List<User> list = userMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			User user = list.get(0);
			Integer did = user.getDid();
			Integer id = deptQueryVo.getId();
			if (did.equals(id)) {
				user.setIsleader(1);
				userMapper.updateByPrimaryKeySelective(user);
			}else {
				不是同一部门
				
				return OAResult.build(500, "不是同一部门，不能选择");
			}
		}*/
		
		return OAResult.ok();
	}

	@Override
	public List<User> findDept_user() throws Exception {
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	@Override
	public String findDept_user(int did) throws Exception {
		UserExample example = new UserExample();
		com.oa.pojo.UserExample.Criteria criteria = example.createCriteria();
		criteria.andDidEqualTo(did);
		criteria.andIsleaderEqualTo(1);
		List<User> list = userMapper.selectByExample(example);
		if (list != null && list.size() >0 ) {
			String Lname = "";
			if (list.size() > 1) {
				for (User user : list) {
					Lname = Lname + user.getUsername() + ",";
				}
				Lname = Lname.substring(0, Lname.length()-1);
			}else {
				for (User user : list) {
					Lname = Lname + user.getUsername();
				}
			}
			return Lname;
		}
		return null;
	}

	@Override
	public List<User> findUserByDid(int did) throws Exception {
		List<User> list = deptMapperCustom.findUserByDid(did);
		
		return list;
	}

	@Override
	public OAResult updateLeader(DeptQueryVo deptQueryVo) throws Exception {
		List<Integer> list = deptQueryVo.getLid();
		Integer id = deptQueryVo.getId();
		UserExample example = new UserExample();
		com.oa.pojo.UserExample.Criteria criteria = example.createCriteria();
		criteria.andDidEqualTo(id);
		List<User> userlist = userMapper.selectByExample(example);
		for (User user : userlist) {
			Integer userid = user.getId();
			for (Integer lid : list) {
				User record = userMapper.selectByPrimaryKey(userid);
				if (userid == lid) {
					record.setIsleader(1);
					userMapper.updateByPrimaryKeySelective(record);
				}else {
					record.setIsleader(0);
					userMapper.updateByPrimaryKeySelective(record);
				}
			}
		}
		return OAResult.ok();
	}

	
	
}
