package com.oa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.pojo.EasyUIMenu;
import com.oa.service.LoginService;
import com.oa.vo.ActiveUser;
import com.oa.web.utils.Constant;

/**
 * 
 * <p>Title:IndexController </p>
 * <p>Description: 登陆和获取菜单的controller</p>
 * <p>Company: </p>
 * @author jdd
 * @date 2017年2月17日 下午3:50:20
 *
 */
@Controller
public class IndexController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public String showIndex(){
//		return "first";
		return "login";
	}
	
/*	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}*/
	
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page,HttpSession session,Model model){
		ActiveUser activeUser = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		model.addAttribute("activeUser", activeUser);
		return page;
	}
	
	@RequestMapping("/getMenuList")
    @ResponseBody
    public Map getMenuList(HttpSession session){
		ActiveUser activeUser = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = activeUser.getUserid();
		Integer parentId = 0 ;//默认所有的父节点id为0
		Map menulist = loginService.getMenuList(parentId,userid);
        return menulist;
    }
	
	@RequestMapping("/refuse")
	public String refusePage(){
		return "refuse";
	}
	
}
