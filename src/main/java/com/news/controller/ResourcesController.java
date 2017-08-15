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
import com.news.entity.ComboTree;
import com.news.entity.Resources;
import com.news.service.ResourcesService;

/**
 * wangxilu
 */
@Controller
@RequestMapping("/sys/permissions")
public class ResourcesController extends BaseController {
	
    /**
     * 请求前缀
     */
    private static final String urlParent = "/sys/permissions/";
    @Autowired
    private ResourcesService resourcesService;
    
    /**
     * 查询参数
     */
    protected HashMap<String, Object> getQueryMap() {
        HashMap<String, Object> map =super.getQueryMap();
        // 查询字段相关参数
        if (StringUtils.isNotBlank(request.getParameter("name"))) {
            map.put("name", request.getParameter("name"));
        }
        if (StringUtils.isNotBlank(request.getParameter("type"))) {
            map.put("type", request.getParameter("type"));
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
        WebPage<Resources> page = resourcesService.findPage(map) ;
        mv.addObject("page", page);
        mv.addObject("urlParent",urlParent);
        mv.setViewName("admin/admin-permission");
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
        mv.setViewName("admin/admin-permission-add");
        return mv;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public WebPage<Resources> list(){
        HashMap<String, Object> map = this.getQueryMap();
        WebPage<Resources> json = resourcesService.findPage(map) ;
        return json;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo save(@RequestParam(value = "name", required = false) String name,
    		@RequestParam(value = "url", required = false) String url,
    		@RequestParam(value = "pId", required = false) Integer pId,
    		@RequestParam(value = "type", required = false) Integer type){
        ReturnInfo ri = new ReturnInfo();
        try {
        	Resources  resources = new Resources();
        	
        	Date date = new Date();
        	resources.setCreateTime(date);
        	resources.setName(name);
        	resources.setType(type);
        	resources.setUrl(url);
        	if("".equals(url)){
        		resources.setpId(0);
        	}else{
        		resources.setpId(pId);
        	}
        	resourcesService.insert(resources);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("新增信息失败!");
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
        mv.setViewName("admin/admin-permission-edit");
        //根据用户ID查询用户信息
        Resources resources = resourcesService.findById(id);
        if(resources.getpId()!=0){
        	Resources pResource = resourcesService.findById(resources.getpId());
            resources.setpName(pResource.getName());
        }else{
        	resources.setpName("系统根菜单");
        }
        
        mv.addObject("resources",resources);
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo update(@RequestParam(value = "id", required = false) Integer id,
    		@RequestParam(value = "name", required = false) String name,
    		@RequestParam(value = "url", required = false) String url,
    		@RequestParam(value = "pId", required = false) Integer pId,
    		@RequestParam(value = "type", required = false) Integer type){
        ReturnInfo ri = new ReturnInfo();
        try {
        	Resources resources = new Resources();
        	
        	resources.setName(name);
        	resources.setUrl(url);
        	resources.setType(type);
        	resources.setId(id);
        	resources.setOperateTime(new Date());
        	resources.setOperator(super.getAdminLoginUser().getAccount());
        	resources.setOperatorId(super.getAdminLoginUser().getCreatorId());
        	resourcesService.update(resources);
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
    public Resources detail(@PathVariable Integer id){
        Resources Resources = resourcesService.findById(id);
        return Resources;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo delete(@PathVariable Integer id){
        ReturnInfo ri = new ReturnInfo();
        try {
        	resourcesService.delete(id);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("删除信息失败!");
            e.printStackTrace();
        }
        return ri;
    }
    
    @RequestMapping(value = "/toSortNum")
	public ModelAndView sortNum(){
		ModelAndView mv = new ModelAndView();
		List<Resources> retList = this.resourcesService.showMenuResource();
		mv.addObject("retList", retList);
		return mv;
	}
	
	@RequestMapping(value = "/saveOrUpdateSortNum")
	public ModelAndView saveOrUpdateSortNum(Resources t){
		System.out.println(t.getChildList());
		for(Resources res : t.getChildList()){
			if(res.getId() != null){
				this.resourcesService.update(res);
			}
		}
		return new ModelAndView();
	}
	@RequestMapping(value = "/getComboTree", method = RequestMethod.POST)
	@ResponseBody
	public List<ComboTree> getComboTree(){
		return this.resourcesService.getComboTree();
	}
    
}
