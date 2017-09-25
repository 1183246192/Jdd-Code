package yycg.base.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import yycg.base.service.UserService;

@Controller
public class FirstAction {
	
	@Resource
	UserService userService;
	
	@RequestMapping("/first")
	public String First(Model model) throws Exception {
		return "/base/first";
	}
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "/base/welcome";
	}
}
