package com.oa.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.oa.mapper.MenusMapper;
import com.oa.mapper.OperateurlMapper;
import com.oa.mapper.UserpermissionMapper;
import com.oa.pojo.Menus;
import com.oa.pojo.MenusExample;
import com.oa.pojo.Operateurl;
import com.oa.pojo.OperateurlExample;
import com.oa.pojo.Userpermission;
import com.oa.pojo.UserpermissionExample;
import com.oa.pojo.UserpermissionExample.Criteria;
import com.oa.vo.ActiveUser;
import com.oa.web.utils.Constant;

/**
 * 
 * <p>Title:PermissionInterceptor </p>
 * <p>Description: url拦截器</p>
 * <p>Company: </p>
 * @author jdd
 * @date 2017年2月17日 
 *
 */
public class PermissionInterceptor implements HandlerInterceptor {

	@Autowired
	private UserpermissionMapper permissionMapper;
	
	@Autowired
	private MenusMapper menusMapper;
	
	@Autowired
	private OperateurlMapper operateurlMapper;
	
	/**
	 * 权限拦截方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		//校验用户请求的地址是否是公开地址
		//获取用户请求的url
		String url = request.getRequestURI();
		//例如：/login
		
//		if (url.equals("/")) {
//			return true;
//		}
		//判断url是否属于公开地址，如果是公开地址放行
		//获取公开地址
		List<String> openurl_list = new ArrayList<String>();
		openurl_list.add("/index");
		openurl_list.add("/getMenuList");
		openurl_list.add("/login");
		openurl_list.add("/welcome");
		openurl_list.add("/refuse");
//		openurl_list.add("/");
		
		//校验请求的url是否在公开地址内
		for(String open_url:openurl_list){
			if(url.indexOf(open_url)>=0){
				return true;//如果是公开地址则放行
			}
		}
		
		//是否是用户的操作权限
		//从session中拿到用户的操作权限
		//获取session
		HttpSession session = request.getSession();
		//用户身份信息
		ActiveUser activeUser = (ActiveUser)session.getAttribute(Constant.USER_SESSION_KEY);
		if (activeUser.getUsername().equals("admin")) {
			return true;
		}
		int userid = activeUser.getUserid();
		UserpermissionExample example = new UserpermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Userpermission> list = permissionMapper.selectByExample(example);
		Userpermission userpermission = list.get(0);
//		String g1 = userpermission.getGroup1().substring(1, 6);
		List<String> groups = new ArrayList<String>(); //把所有的group加到list中
		groups.add(userpermission.getGroup1());
		groups.add(userpermission.getGroup2());
		groups.add(userpermission.getGroup3());
		groups.add(userpermission.getGroup4());
		groups.add(userpermission.getGroup5());
		
		List<String> operations = new ArrayList<String>();
		for (int i = 0; i < groups.size(); i++) {
			String group = groups.get(i) ;
			if (group.substring(0, 1).equals("0")) {
				continue;
			}
			MenusExample ex = new MenusExample();
			com.oa.pojo.MenusExample.Criteria criteria2 = ex.createCriteria();
			criteria2.andIsParentEqualTo(0);
			criteria2.andMenuidLike((i+1)+"%");
			List<Menus> mlist = menusMapper.selectByExample(ex);//加载所有菜单
			for (Menus menus : mlist) {
				String url2 = menus.getUrl();
				operations.add(url2);
				
				Integer id = menus.getId();
				OperateurlExample example2 = new OperateurlExample();
				com.oa.pojo.OperateurlExample.Criteria criteria3 = example2.createCriteria();
				criteria3.andMenuidEqualTo(id);
				List<Operateurl> list2 = operateurlMapper.selectByExample(example2);
				for (Operateurl operateurl : list2) {
					operations.add(operateurl.getUrl());
				}
			}
		}
		
		//校验请求的url是否在用户操作权限地址内
		for(String operation : operations){
			if(url.indexOf(operation) >= 0){
				return true;//如果是用户的操作权限 地址则放行
			}
		}
		
		//提示用户无此操作权限
		//跳转到无此操作权限操作页面
		response.sendRedirect("/refuse");
//	    request.getRequestDispatcher("/WEB-INF/jsp/refuse.jsp").forward(request, response);
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
    
}
