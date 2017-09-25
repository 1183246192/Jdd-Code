package com.oa.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.common.pojo.OAResult;
import com.oa.pojo.User;
import com.oa.service.LoginService;
import com.oa.vo.ActiveUser;
import com.oa.vo.LoginModel;
import com.oa.web.utils.Constant;

/**
 * 
 * <p>Title:LoginController </p>
 * <p>Description: 登陆、登出、修改密码</p>
 * <p>Company: </p>
 * @author jdd
 * @date 2017年2月17日 下午3:51:24
 *
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/loginSubmit")
	public String login(LoginModel loginModel,HttpSession session,Model model) {
		String authCode = (String) session.getAttribute(Constant.AUTH_CODE);
		String username = loginModel.getUsername();
		String password = loginModel.getPasswd();
		String code = loginModel.getAuthCode();
		if (StringUtils.isNotEmpty(code)&&code.equalsIgnoreCase(authCode)) {
			ActiveUser user = loginService.findUserByuserandpass(username, password);
			if (user != null) {
				session.setAttribute(Constant.USER_SESSION_KEY, user);
				model.addAttribute("activeUser", user);
				return "redirect:index";
			}else {
				String message="用户不存在或密码错！";
				model.addAttribute("message", message);
				return "forward:login";
			}
			
		}else {
			String message="验证码错误！";
			model.addAttribute("message", message);
			return "forward:login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute(Constant.USER_SESSION_KEY, null);
		return "redirect:index";
	}

	@RequestMapping("/update/pwd")
	public String updatepwd(HttpSession session,Model model) {
		ActiveUser activeUser = (ActiveUser) session.getAttribute(Constant.USER_SESSION_KEY);
		int userid = activeUser.getUserid();
		User user = loginService.findUserByUserid(userid);
		model.addAttribute("user", user);
		return "updatepwd";
	}
	
	@RequestMapping(value="/updatepass",method=RequestMethod.POST)
	@ResponseBody
	public OAResult updatepassword(User user) {
		OAResult result = loginService.updateUserPass(user);
		return result;
	}
	
	
}
