package com.news.controller;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.news.entity.Admin;

/**
 * 提供分页等公用操作
 *
 * @author wangxilu
 */
public class BaseController {
	
	public final String TIME_START_DEFAULT = " 00:00:00";
	public final String TIME_END_DEFAULT = " 23:59:59";

    // 子类可以直接使用request对象,开发测试期加required=false，生产环境去掉
    @Autowired(required = false)
    protected HttpServletRequest request;

    /**
     * 用于日期格式的转换，页面中有日期格式的需要方面做转换
     * 
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * 获取当前系统登录用户
     * 
     * @return
     */
//    protected Admin getAdminLoginUser() {
//        HttpSession session = request.getSession();
//        return null;
//    }

    /**
     * 获取当前登录用户
     * 
     * @return
     */
    protected String getLoginUser() {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("user");

    }
    
    protected Admin getAdminLoginUser() {
        HttpSession session = request.getSession();
        return (Admin) session.getAttribute(LoginController.SESSION_ADMIN_LOGIN);
    }
    
    protected HttpSession newSession(HttpServletRequest request) {
		HttpSession oldSession = request.getSession();
		if (null != oldSession) {
			oldSession.invalidate();
		}
		return request.getSession(true);
	}
    

    protected HashMap<String, Object> getQueryMap() {
        int page = 1;
        int rows = 20;

        // 翻页相关参数
        HashMap<String, Object> map = new HashMap<String, Object>();
        page = StringUtils.isNotBlank(request.getParameter("page"))
                && StringUtils.isNumeric(request.getParameter("page")) ? Integer
                .parseInt(request.getParameter("page")) : page;
        rows = StringUtils.isNotBlank(request.getParameter("rows"))
                && StringUtils.isNumeric(request.getParameter("rows")) ? Integer
                .parseInt(request.getParameter("rows")) : rows;
        int startIndex = (page - 1) * rows < 0 ? 0 : (page - 1) * rows;
        map.put("startIndex", startIndex);
        map.put("rows", rows);
        map.put("page", page);
        return map;
    }

    /**
     * 参数转换为Bean对象，用于多文件上传file名不同时，无法自动封装Bean的场景
     *
     * @param request
     * @param clazz
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    protected <T> T transformParamToBean(HttpServletRequest request, Class<T> clazz)
            throws Exception {
        Object result = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (StringUtils.isNotBlank(request.getParameter(field.getName()))) {
                field.setAccessible(true);
                if (field.getType() == Integer.class) {
                    field.set(result, Integer.valueOf(request.getParameter(field.getName())));
                } else if (field.getType() == Long.class) {
                    field.set(result, Long.valueOf(request.getParameter(field.getName())));
                } else if (field.getType() == Date.class) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    dateFormat.setLenient(false);
                    field.set(result, dateFormat.parse(request.getParameter(field.getName())));
                } else {
                    field.set(result, request.getParameter(field.getName()));
                }
            }
        }

        return (T) result;
    }
}
