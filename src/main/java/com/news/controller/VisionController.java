package com.news.controller;

import java.util.Date;
import java.util.HashMap;

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
import com.news.entity.Vision;
import com.news.service.VisionService;

/**
 * wangxilu
 */
@Controller
@RequestMapping("/sys/vision")
public class VisionController extends BaseController {
	

    /**
     * 请求前缀
     */
    private static final String urlParent = "/sys/vision/";
    @Autowired
    private VisionService visionService;
    
    /**
     * 查询参数
     */
    protected HashMap<String, Object> getQueryMap() {
        HashMap<String, Object> map =super.getQueryMap();
        // 查询字段相关参数
        if (StringUtils.isNotBlank(request.getParameter("visionCode"))) {
            map.put("visionCode", request.getParameter("visionCode"));
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
        HashMap<String, Object> map = this.getQueryMap();
        WebPage<Vision> page = visionService.findPage(map) ;
        mv.addObject("page", page);
        mv.addObject("urlParent",urlParent);
        mv.setViewName("vision/vision-list");
        return mv;
    }
    
    /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping(value = "/toadd")
    public ModelAndView toadd(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("urlParent",urlParent);
        mv.setViewName("vision/vision-add");
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo save(@RequestParam(value = "url", required = false) String url,
    		@RequestParam(value = "describtion", required = false) String describtion,
    		@RequestParam(value = "visionCode", required = false) String visionCode){
        ReturnInfo ri = new ReturnInfo();
        try {
        	Vision  vision = new Vision();
        	
        	vision.setVisionTime(new Date());
        	vision.setUrl(url);
        	vision.setDescribtion(describtion);
        	vision.setVisionCode(visionCode);
        	visionService.insert(vision);
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
        mv.setViewName("vision/vision-edit");
        //根据用户ID查询用户信息
        Vision vision = visionService.findById(id);
        mv.addObject("vision",vision);
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo update(@RequestParam(value = "id", required = false) Integer id,
    		@RequestParam(value = "url", required = false) String url,
    		@RequestParam(value = "describtion", required = false) String describtion,
    		@RequestParam(value = "visionCode", required = false) String visionCode){
        ReturnInfo ri = new ReturnInfo();
        try {
            Vision  vision = new Vision();
            
            vision.setId(id);
        	
        	vision.setVisionTime(new Date());
        	vision.setUrl(url);
        	vision.setDescribtion(describtion);
        	vision.setVisionCode(visionCode);
        	visionService.update(vision);
        } catch (Exception e) {
            ri.setHasError(true);
            ri.setErrorCode("Exception");
            ri.setErrormsg("编辑信息失败!");
            e.printStackTrace();
        }
        return ri;
    }
    
}
