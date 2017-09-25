package com.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.OAResult;
import com.oa.pojo.Department;
import com.oa.pojo.User;
import com.oa.service.DeptService;
import com.oa.vo.DeptQueryVo;

/**
 * 
 * <p>Title:DeptController </p>
 * <p>Description: 对应jsp目录下dept目录中所有带有dept的jsp的url请求</p>
 * <p>Company: </p>
 * @author jdd
 * @date 2017年2月17日 
 *
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	
	//查询展示页面
	@RequestMapping("/querydept")
	public String queryDept(){
		return "dept/querydept";
	}
	
	@RequestMapping("/querydept_result")
	@ResponseBody
	public EasyUIDataGridResult getDeptList(DeptQueryVo deptQueryVo,Integer page,Integer rows) throws Exception{
		deptQueryVo = deptQueryVo != null ? deptQueryVo : new DeptQueryVo();
		
		EasyUIDataGridResult result = deptService.getDepartList(deptQueryVo,page, rows);
		return result;
	}
	
	@RequestMapping("/adddept")
	public String findDept(Model model){
		
		return "dept/adddept";
	}
	
	@RequestMapping("/editdept")
	public String editDept(Model model,HttpServletRequest request) throws Exception{
		String dept_id = request.getParameter("id");	
		int id = Integer.parseInt(dept_id);
		Department department = deptService.getDeptById(id);
		List<User> list = deptService.findDept_user();
		String user = deptService.findDept_user(id);		//根据did查询用户
		if (department != null) {
			model.addAttribute("department", department);
		}
		if (list != null) {
			model.addAttribute("list", list);
		}
		if (user != null){
			model.addAttribute("record", user);
		}
		return "dept/editdept";
	}
	
	@RequestMapping(value="/insertdept",method=RequestMethod.POST)
	@ResponseBody
	public OAResult insertDept(DeptQueryVo deptQueryVo) throws Exception{
		OAResult result = deptService.insertDept(deptQueryVo);
		return result;
	}
	
	@RequestMapping(value="/updatedept",method=RequestMethod.POST)
	@ResponseBody
	public OAResult updateDept(DeptQueryVo deptQueryVo) throws Exception{
		OAResult result = deptService.updateDept(deptQueryVo);
		return result;
	}
	
	@RequestMapping("/editleader")
	public String editLeader(Model model,HttpServletRequest request) throws Exception{
		String dept_id = request.getParameter("id");	
		int id = Integer.parseInt(dept_id);
		List<User> list = deptService.findUserByDid(id);
		Department dept = deptService.getDeptById(id);
		if (dept != null && list != null && list.size() > 0) {
			model.addAttribute("department", dept);
			model.addAttribute("list", list);
		}
		return "dept/editleader";
	}
	
	@RequestMapping(value="/updateleader",method=RequestMethod.POST)
	@ResponseBody
	public OAResult updateLeader(DeptQueryVo deptQueryVo) throws Exception{
		OAResult result = deptService.updateLeader(deptQueryVo);
		return result;
	}
}
