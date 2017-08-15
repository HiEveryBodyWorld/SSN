package com.news.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.news.entity.Admin;
import com.news.entity.Resources;


public class SystemInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI() + "?"  + request.getQueryString();
		Admin admin = (Admin) request.getSession().getAttribute(LoginController.SESSION_ADMIN_LOGIN);
		if (admin == null) {
			response.sendRedirect("/");
			return false;
		}
		//获取导航条
		List<Resources> perList = admin.getPermitResourcesList();
		StringBuffer sb = new StringBuffer();
		for(Resources res : perList){
			for(Resources child : res.getChildList()){
				if(uri.contains(child.getUrl())){
					sb.append(res.getName()).append(">>").append(child.getName());
				}else{
					for(Resources action : child.getActionList()){
						Resources r3 = null;
						Resources r2 = null;
						if(uri.contains(action.getUrl())){
							Integer pid3 = action.getpId().intValue();
							if(pid3.intValue() == child.getId().intValue()){
								r3 = child;
								if(r3.getpId().intValue() == res.getId().intValue()){
									r2 = res;
								}
							}
							sb.delete(0, sb.length());
							sb.append(r2.getName()).append(">>").append(r3.getName());
							sb.append(">>").append(action.getName());
						}
					}
				}
			}
		}
		//访问资源是否授权，否直接登录页面
		/*boolean permitFlag = false;
		List<Resources> perListNoLevel = admin.getPermitResourcesListNoLevel();
		for(Resources res : perListNoLevel){
			String url = "".equals(res.getUrl()) ? "null" : res.getUrl();
			if(uri.contains(url)){
				permitFlag = true;
			}
		}
		if(!permitFlag){
			response.sendRedirect("/");
			return false;
		}*/
		request.getSession().setAttribute(LoginController.SESSION_ADMIN_NAVIGATE, sb.toString());
		return super.preHandle(request, response, handler);
	}
	
}
