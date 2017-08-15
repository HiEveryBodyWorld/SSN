package com.news.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.State;
import com.news.common.WebPage;
import com.news.entity.ImagesDetail;
import com.news.entity.ManageImages;
import com.news.entity.OthersManage;
import com.news.service.ManageImageService;
import com.news.service.OthersManageService;

@Controller
@RequestMapping(value="/sys")
public class OthersManageController extends BaseController{
	
	
	@Autowired
	OthersManageService othersManageService;
	
	@Autowired
	ManageImageService manageImageService;
	
	
	@RequestMapping(value="/news/tolist")
	public ModelAndView tolist(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
        HashMap<String, Object> map = this.getQueryMap();
        map.put("type", 0);
        WebPage<OthersManage> page = othersManageService.findPage(map) ;
        mv.addObject("news",page);
        mv.setViewName("others/news-list");
        	
        return mv;
	}
	
	@RequestMapping(value="/square/toadd")
	public ModelAndView tosquareadd(){
		
		ModelAndView mv = new ModelAndView();
        mv.setViewName("others/square-add");
        	
        return mv;
	}
	
	@RequestMapping(value="/square/tolist")
	public ModelAndView tosquarelist(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
        HashMap<String, Object> map = this.getQueryMap();
        map.put("type", 1);
        WebPage<OthersManage> page = othersManageService.findPage(map) ;
        mv.addObject("news",page);
        mv.setViewName("others/square-list");
        	
        return mv;
	}
	
	@RequestMapping(value="/news/toadd")
	public ModelAndView toadd(){
		
		ModelAndView mv = new ModelAndView();
        mv.setViewName("others/news-add");
        	
        return mv;
	}
	
	
	
	@RequestMapping(value="/industrynew/toadd")
	public ModelAndView toindustrynewadd(){
		
		ModelAndView mv = new ModelAndView();
        mv.setViewName("others/industrynew-add");
        	
        return mv;
	}
	
	@RequestMapping(value="/industrynew/tolist")
	public ModelAndView toindustrynewlist(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
        HashMap<String, Object> map = this.getQueryMap();
        map.put("type", 2);
        WebPage<OthersManage> page = othersManageService.findPage(map) ;
        mv.addObject("news",page);
        mv.setViewName("others/industrynew-list");
        	
        return mv;
	}
	
	@RequestMapping(value="/culturalproject/toadd")
	public ModelAndView toculturalprojectadd(){
		
		ModelAndView mv = new ModelAndView();
        mv.setViewName("others/culturalproject-add");
        	
        return mv;
	}
	
	@RequestMapping(value="/culturalproject/tolist")
	public ModelAndView toculturalprojectlist(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
        HashMap<String, Object> map = this.getQueryMap();
        map.put("type", 3);
        WebPage<OthersManage> page = othersManageService.findPage(map) ;
        mv.addObject("news",page);
        mv.setViewName("others/culturalproject-list");
        	
        return mv;
	}
	
	protected HashMap<String, Object> getQueryMap() {
        HashMap<String, Object> map=super.getQueryMap();
        // 查询字段相关参数
        if (StringUtils.isNotBlank(request.getParameter("startDate"))) {
            map.put("startDate", request.getParameter("startDate"));
        }
        if (StringUtils.isNotBlank(request.getParameter("endDate"))) {
            map.put("endDate", request.getParameter("endDate"));
        }
        if (StringUtils.isNotBlank(request.getParameter("title"))) {
            map.put("title", request.getParameter("title"));
        }
        
        return map;

    }
	 /**
     * 上传图片
     */
    @RequestMapping(value = "/others/upload", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo upload(MultipartHttpServletRequest  request){
    	List<MultipartFile> files = (List<MultipartFile>) request.getFiles("file");
		
        ReturnInfo ri = new ReturnInfo();
        try {
        	List<Integer> list = new ArrayList<Integer>();
        	
        	if(files!=null){
        		Integer id = new Integer(0);
                for(int i=0;i<files.size();i++){  
                    MultipartFile file = files.get(i);  
                     id = othersManageService.insertImages(file);
                     list.add(id);
                } 
            }
        	ri.setResult(list);
        	ri.setErrorCode("200");
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("上传图片失败");
            e.printStackTrace();
        }
        return ri;
    }
    
    /**
     * 上传图片
     */
    @RequestMapping(value = "/others/uploadup", method = RequestMethod.POST)
    @ResponseBody
    public String uploadup(MultipartHttpServletRequest  request){
    	State state = null;
    	state = new BaseState(true);
    	List<MultipartFile> files = (List<MultipartFile>) request.getFiles("upfile");
        try {
        	if(files!=null){
        		Integer id = new Integer(0);
                for(int i=0;i<files.size();i++){  
                    MultipartFile file = files.get(i);  
                     id = othersManageService.insertImages(file);
                     ImagesDetail imd = othersManageService.findImagesById(id);
                     state.putInfo("url", imd.getUrl());
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String resultState = state.toJSONString();
        return resultState;
    }
    @RequestMapping(value = "/others/toedit/{id}")
    public ModelAndView toedit(@PathVariable Integer id){
    	 ModelAndView mv = new ModelAndView();
    	 OthersManage om = othersManageService.findById(id);
    	 List<ManageImages> mis = manageImageService.findUrlByManageId(id);
    	 mv.addObject("others",om);
    	 mv.addObject("images", mis);
    	 if(om.getType() == 0){
    		 mv.setViewName("others/news-edit");
    	 }else if(om.getType() == 1){
    		 mv.setViewName("others/square-edit");
    	 }else if(om.getType() == 2){
    		 mv.setViewName("others/industrynew-edit");
    	 }else if(om.getType() == 3){
    		 mv.setViewName("others/culturalproject-edit");
    	 }
         return mv;
    }
    @RequestMapping(value = "/others/toshow/{id}")
    public ModelAndView toshow(@PathVariable Integer id){
    	 ModelAndView mv = new ModelAndView();
    	 OthersManage om = othersManageService.findById(id);
    	 List<ManageImages> mis = manageImageService.findUrlByManageId(id);
    	 mv.addObject("others",om);
    	 mv.addObject("images", mis);
    	 if(om.getType() == 0){
    		 mv.setViewName("others/news-show");
    	 }else if(om.getType() == 1){
    		 mv.setViewName("others/square-show");
    	 }else if(om.getType() == 2){
    		 mv.setViewName("others/industrynew-show");
    	 }else if(om.getType() == 3){
    		 mv.setViewName("others/culturalproject-show");
    	 }
         return mv;
    }
    
    /**
     * 保存信息
     */
    @RequestMapping(value = "/others/add", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo add(@RequestParam(value = "description", required = false) String description,
    		@RequestParam(value = "ids", required = false) String ids,//ids 上传的所有id
    		@RequestParam(value = "title",required = false) String title,
    		@RequestParam(value ="subtitle",required = false) String subtitle,
    		@RequestParam(value="content",required = false) String content,
    		@RequestParam(value="comment",required = false) String comment,
    		@RequestParam(value="source",required = false) String source,
    		@RequestParam(value="type",required = false) Integer type,
    		@RequestParam(value="status",required = false) Integer status
    		){
        ReturnInfo ri = new ReturnInfo();
        try {
        	OthersManage model = new OthersManage();
        	model.setCreateTime(new Date());
        	model.setUpdateTime(new Date());
        	if(null == description || "".equals(description)){
        		model.setDescription(null);
        	}else{
        		model.setDescription(description);
        	}
        	if(ids.contains("undefined") || "".equals(ids)){
        		model.setIds(null);
        	}else{
        		model.setIds(ids);
        	}
        	model.setOperator(super.getAdminLoginUser().getAccount());
        	model.setOperatorId(super.getAdminLoginUser().getId());
        	model.setTitle(title);
        	model.setSubtitle(subtitle);
        	model.setComment(comment);
        	model.setContent(content);
        	model.setSource(source);
        	model.setType(type);
        	model.setStatus(status);
        	int insertID = othersManageService.insert(model);
        	ri.setResult(insertID);
        	ri.setHasError(false);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("插入数据失败");
            e.printStackTrace();
        }
        return ri;
    }
    
    @RequestMapping(value = "/others/update", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo update(@RequestBody OthersManage om){
        ReturnInfo ri = new ReturnInfo();
        try {
             othersManageService.update(om);
             ri.setHasError(false);
             ri.setResult("更新成功！");
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("编辑信息失败!");
            e.printStackTrace();
        }
        return ri;
    }
    
}
