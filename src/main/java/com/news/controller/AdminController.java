package com.news.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.news.common.WebPage;
import com.news.entity.Admin;
import com.news.entity.Role;
import com.news.service.AdminRoleService;
import com.news.service.AdminService;
import com.news.service.RoleService;

/**
 * wangxilu
 */
@Controller
@RequestMapping("/sys/admin")
public class AdminController extends BaseController {
	
	
	
	
	
    /**
     * 请求前缀
     */
    final String urlParent = "/sys/admin/";
    @Autowired AdminService adminService;
    @Autowired RoleService roleService;
    @Autowired AdminRoleService adminRoleService;
    
    /**
     * 查询参数
     */
    protected HashMap<String, Object> getQueryMap() {
        HashMap<String, Object> map =super.getQueryMap();
        // 查询字段相关参数
        if (StringUtils.isNotBlank(request.getParameter("account"))) {
            map.put("account", request.getParameter("account"));
        }
        if (StringUtils.isNotBlank(request.getParameter("startDate"))) {
            map.put("startDate", request.getParameter("startDate"));
        }
        if (StringUtils.isNotBlank(request.getParameter("endDate"))) {
            map.put("endDate", request.getParameter("endDate"));
        }
        return map;
    }

    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping(value = "/tolist")
    public ModelAndView tolist(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("urlParent",urlParent);
        mv.setViewName("admin/admin-list");
        HashMap<String, Object> map = this.getQueryMap();
        WebPage<Admin> page = adminService.findPage(map) ;
        List<Role> roleList = this.roleService.findListAll();
        mv.addObject("page", page);
        mv.addObject("roleList", roleList);
        return mv;
    }
    
    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping(value = "/toadd")
    public ModelAndView toadd(){
        ModelAndView mv = new ModelAndView();
        HashMap<String, Object> map = this.getQueryMap();
        WebPage<Role> page = roleService.findPage(map) ;
        mv.addObject("page", page);
        mv.addObject("urlParent",urlParent);
        mv.setViewName("admin/admin-add");
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo save(@RequestParam(value = "account", required = false) String account,
    		@RequestParam(value = "realName", required = false) String realName,
    		@RequestParam(value = "password", required = false) String password,
    		@RequestParam(value = "mobile", required = false) String mobile,
    		@RequestParam(value = "email", required = false) String email,
    		@RequestParam(value = "roleId", required = false) Integer roleId){
        ReturnInfo ri = new ReturnInfo();
        Admin admin = new Admin();
        try {
        	//根据用户名查寻用户信息
        	Admin adminDb = adminService.findByUsername(account);
        	
        	if(adminDb!=null){
        		ri.setErrorCode("2001");
        		ri.setErrormsg("该用户已存在！");
        	}else{
        		admin.setRealName(realName);
        		admin.setEmail(email);
        		admin.setAccount(account);
            	admin.setMobile(mobile);
            	admin.setPassword(password);
            	admin.setCreateTime(new Date());
            	admin.setCreator(super.getAdminLoginUser().getAccount());
            	admin.setCreatorId(super.getAdminLoginUser().getId());
            	adminService.insertLogic(admin,roleId);
        	}
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("新增信息失败!");
            e.printStackTrace();
        }
        return ri;
    }
    
    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping(value = "/toedit/{id}")
    public ModelAndView toedit(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/admin-edit");
        //根据用户ID查询用户信息
        Admin admin = adminService.findById(id);
        mv.addObject("admin",admin);
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo update(@RequestParam(value = "id", required = false) Integer id,
    		@RequestParam(value = "account", required = false) String account,
    		@RequestParam(value = "password", required = false) String password,
    		@RequestParam(value = "mobile", required = false) String mobile,
    		@RequestParam(value = "email", required = false) String email,
    		@RequestParam(value = "isDel", required = false) Integer isDel){
        ReturnInfo ri = new ReturnInfo();
        //根据ID查询用户信息
        Admin admin = adminService.findById(id);
        try {
        	admin.setAccount(account);
        	admin.setPassword(password);
        	admin.setMobile(mobile);
        	admin.setEmail(email);
        	admin.setIsDel(isDel);
        	admin.setOperateTime(new Date());
        	admin.setOperator(super.getAdminLoginUser().getAccount());
        	admin.setOperatorId(super.getAdminLoginUser().getCreatorId());
        	adminService.update(admin);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("编辑信息失败!");
            e.printStackTrace();
        }
        return ri;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Admin detail(@PathVariable Integer id){
        Admin Admin = adminService.findById(id);
        return Admin;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo delete(@PathVariable Integer id){
        ReturnInfo ri = new ReturnInfo();
        try {
        	adminService.delete(id);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("删除信息失败!");
            e.printStackTrace();
        }
        return ri;
    }
    
    @RequestMapping(value = "/deletes/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo delete(@PathVariable String ids){
        ReturnInfo ri = new ReturnInfo();
        try {
        	adminService.deletes(ids);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("删除信息失败!");
            e.printStackTrace();
        }
        return ri;
    }
    
}
