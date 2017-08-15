package com.news.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.news.common.WebPage;
import com.news.entity.Resources;
import com.news.entity.Role;
import com.news.entity.RoleResources;
import com.news.service.ResourcesService;
import com.news.service.RoleResourcesService;
import com.news.service.RoleService;

/**
 * wangxilu
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController extends BaseController {
	
    /**
     * 请求前缀
     */
    private static final String urlParent = "/sys/role/";
    
    /**
     * 首页
     */
    private static final String INDEX_PAGE = "admin/admin-role";
    @Autowired 
    RoleService beanService;
    @Autowired 
    ResourcesService resourcesService;
    @Autowired
    RoleResourcesService roleResourcesService;
    
    /**
     * 查询参数
     */
    protected HashMap<String, Object> getQueryMap() {
        HashMap<String, Object> map =super.getQueryMap();
        // 查询字段相关参数
        if (StringUtils.isNotBlank(request.getParameter("name"))) {
            map.put("name", request.getParameter("name"));
        }
        if (StringUtils.isNotBlank(request.getParameter("desc"))) {
            map.put("desc", request.getParameter("desc"));
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
        HashMap<String, Object> map = this.getQueryMap();
        WebPage<Role> page = beanService.findPage(map) ;
        mv.addObject("page", page);
        mv.setViewName(INDEX_PAGE);
        return mv;
    }

    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping(value = "/toadd")
    public ModelAndView toadd(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("urlParent",urlParent);
        List<Resources> resourcesList = this.resourcesService.showActionResource();
        mv.addObject("resourcesList", resourcesList);
        mv.setViewName("admin/admin-role-add");
        return mv;
    }
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public WebPage<Role> list(){
        HashMap<String, Object> map = this.getQueryMap();
        WebPage<Role> json = beanService.findPage(map) ;
        return json;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo save(@RequestParam(value = "name", required = false) String name,
    		@RequestParam(value = "description", required = false) String description,
    		@RequestParam(value = "resourcesIds", required = false) List<String> resourcesIds){
        ReturnInfo ri = new ReturnInfo();
        try {
        	Role role = new Role();
        	
        	Date date = new Date();
        	role.setName(name);
        	role.setDescription(description);
        	role.setCreateTime(date);
        	role.setCreator(super.getAdminLoginUser().getAccount());
        	role.setCreatorId(super.getAdminLoginUser().getCreatorId());
        	beanService.insert(role);
        	
        	RoleResources roleResources = new RoleResources();
        	
        	roleResources.setResourcesIds(resourcesIds);
        	roleResources.setRoleId(role.getId());
        	this.roleResourcesService.insertLogic(roleResources);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            e.printStackTrace();
        }
        return ri;
    }
    /**
     * 跳转编辑页面
     * @return
     */
    @RequestMapping(value = "/toedit/{id}")
    public ModelAndView toedit(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/admin-role-edit");
        //根据用户ID查询用户信息
        Role role = beanService.findById(id);
        List<Resources> resourcesList = this.resourcesService.showActionResource();
        mv.addObject("resourcesList", resourcesList);
        mv.addObject("role",role);
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo update(@RequestParam(value = "roleId", required = false) Integer roleId,
    		@RequestParam(value = "name", required = false) String name,
    		@RequestParam(value = "description", required = false) String description,
    		@RequestParam(value = "resourcesIds", required = false) List<String> resourcesIds){
        ReturnInfo ri = new ReturnInfo();
        try {
        	Role role= new Role();
        	role.setName(name);
        	role.setDescription(description);
        	role.setId(roleId);
        	
        	beanService.update(role);
        	
        	roleResourcesService.deleteByRoleId(roleId);
        	
        	RoleResources roleResources = new RoleResources();
        	
        	roleResources.setResourcesIds(resourcesIds);
        	roleResources.setRoleId(roleId);
        	this.roleResourcesService.insertLogic(roleResources);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            e.printStackTrace();
        }
        return ri;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Role detail(@PathVariable Integer id){
        Role Role = beanService.findById(id);
        return Role;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo delete(@PathVariable Integer id){
        ReturnInfo ri = new ReturnInfo();
        try {
        	beanService.delete(id);
        	//根据角色ID删除权限信息
        	roleResourcesService.deleteByRoleId(id);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            e.printStackTrace();
        }
        return ri;
    }
    
    @RequestMapping(value = "/saveRoleResources", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo saveRoleResources(@RequestBody RoleResources t){
        ReturnInfo ri = new ReturnInfo();
        try {
        	this.roleResourcesService.insertLogic(t);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            e.printStackTrace();
        }
        return ri;
    }
    
    @RequestMapping(value = "/getRoleResources", method = RequestMethod.POST)
    @ResponseBody
    public List<RoleResources> getRoleResources(@RequestParam(value = "roleId", required = true) Integer roleId){
    	HashMap<String,Object> paramsMap = new HashMap<String,Object>();
    	paramsMap.put("roleId", roleId);
      List<RoleResources> list = this.roleResourcesService.findListAllWithMap(paramsMap);
      return list;
    }
    
}
