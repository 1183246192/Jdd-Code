package com.oa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.oa.vo.ActiveUser;
import com.oa.web.utils.Constant;

/**
 * 
 * <p>Title:LoginInterceptor </p>
 * <p>Description: 登陆的拦截器</p>
 * <p>Company: </p>
 * @author jdd
 * @date 2017年2月17日 
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute(Constant.USER_SESSION_KEY);
		if (activeUser != null) {
			//用户放行
			return true;
		}
		response.sendRedirect("/login");
//		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub

	}

}
