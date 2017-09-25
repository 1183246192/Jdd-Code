package com.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.pojo.EasyUIDataGridResult;
import com.oa.common.pojo.EasyUITreeNode;
import com.oa.common.pojo.OAResult;
import com.oa.pojo.Department;
import com.oa.pojo.User;
import com.oa.pojo.Userpermission;
import com.oa.service.UserService;
import com.oa.vo.ActiveUser;
import com.oa.web.utils.Constant;

/**
 * 
 * <p>Title:UserController </p>
 * <p>Description: 对应jsp目录下dept目录中所有带有user的jsp的url请求</p>
 * <p>Company: </p>
 * @author jdd
 * @date 2017年2月17日 
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryuser")
	public String queryUser(){
//		int i = 1/0;
		return "dept/queryuser";
	}
	
	@RequestMapping("/queryuser_result")
	@ResponseBody
	public EasyUIDataGridResult getUserList(User user,Integer page,Integer rows) throws Exception{
		user = user != null ? user : new User();
		
		EasyUIDataGridResult result = userService.getUserList(user,page, rows);
		return result;
	}
	
	@RequestMapping("/addsysuser")
	public String findUser(Model model) throws Exception{
		List<Department> list = userService.getDeptName();
		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
		}
		return "dept/addsysuser";
	}
	
	@RequestMapping("/editsysuser")
	public String editUser(Model model,HttpServletRequest request) throws Exception{
		String user_id = request.getParameter("id");	
		int id = Integer.parseInt(user_id);
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "dept/editsysuser";
	}
	
	@RequestMapping(value="/insertuser",method=RequestMethod.POST)
	@ResponseBody
	public OAResult insertUser(User user) throws Exception{
		OAResult result = userService.insertUser(user);
		return result;
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	@ResponseBody
	public OAResult updateUser(User user) throws Exception{
		OAResult result = userService.updateUser(user);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public OAResult deleteUser(Integer id) throws Exception{
		OAResult result = userService.deleteUser(id);
		return result;
	}
	///user/singleuser
	@RequestMapping("/singleuser")
	public String findSingleUser(){
		return "dept/singleuser";
	}
	//query_singleuser
	@RequestMapping("/query_singleuser")
	@ResponseBody
	public EasyUIDataGridResult getSingleUser(HttpSession session) throws Exception{
		ActiveUser user = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = user.getUserid();
		EasyUIDataGridResult result = userService.getSingleUser(userid);
		return result;
	}
	
	//@RequestParam(value="userid",defaultValue="0") Integer userid
	@RequestMapping("/getTreeByUserId")
	@ResponseBody
	public List<EasyUITreeNode> getTreeByUserId(HttpServletRequest request){
		String userid = request.getParameter("userid");
		Integer user_id = 0;
		if (userid != null) {
			user_id = Integer.parseInt(userid);
		}
		String mid = request.getParameter("id");
		Integer m_id = 0;
		if (mid != null) {
			m_id = Integer.parseInt(mid);
		}
		List<EasyUITreeNode> list = userService.getTreeByUserId(user_id,m_id);
		return list;
	}
	
	@RequestMapping("/updateTreeById")
	@ResponseBody
	public OAResult updateTreeById(HttpServletRequest request){
		String userid = request.getParameter("userid");
		int	user_id = Integer.parseInt(userid);
		String mid = request.getParameter("id");
		String[] ids = mid.split(",");
//		int m_id = Integer.parseInt(mid);
		OAResult result = userService.updateTreeById(user_id, ids);
		return result;
	}
	
}
