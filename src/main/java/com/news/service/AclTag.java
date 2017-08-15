package com.news.service;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.news.controller.LoginController;
import com.news.entity.Admin;

/**
 * 页面访问控制标签
 * @author wangxilu
 *
 */
@SuppressWarnings("serial")
public class AclTag extends RequestContextAwareTag{
	
	/**
	 * 请求的URL
	 */
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@SuppressWarnings("static-access")
	@Override
	protected int doStartTagInternal() throws Exception {
		WebApplicationContext ctx = getRequestContext().getWebApplicationContext();
		Admin admin = (Admin)super.pageContext.getSession().getAttribute(LoginController.SESSION_ADMIN_LOGIN);
		RoleResourcesService permissionService = (RoleResourcesService)ctx.getBean("permissionService");
		Boolean b = permissionService.isPermit(admin, url);
		if(b){
			return super.EVAL_BODY_INCLUDE;
		}
		return super.SKIP_BODY;
	}

}
