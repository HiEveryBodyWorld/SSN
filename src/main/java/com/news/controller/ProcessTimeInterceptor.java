package com.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangxilu
 *
 */
public class ProcessTimeInterceptor extends HandlerInterceptorAdapter {
	
	private final Logger _log = LoggerFactory.getLogger(ProcessTimeInterceptor.class);
	/**
	 * 请求执行开始时间
	 */
	private static final String START_TIME = "_start_time";
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute(START_TIME, System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}

	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long time = (Long) request.getAttribute(START_TIME);
		time = System.currentTimeMillis() - time;
		_log.info("Process In:[{}]$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$Elapsed.Time [{}] ms",  request.getRequestURI(), time);
		super.afterCompletion(request, response, handler, ex);
	}

	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	

}
