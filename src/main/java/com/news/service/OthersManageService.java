package com.news.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.news.common.OSSClientUtil;
import com.news.common.WebPage;
import com.news.dao.ImageDetailDao;
import com.news.dao.ManageImageDao;
import com.news.dao.OthersManageDao;
import com.news.entity.ImagesDetail;
import com.news.entity.ManageImages;
import com.news.entity.OthersManage;

@Service
public class OthersManageService implements BaseService<OthersManage,Integer>{
	
	@Resource
	private OthersManageDao othersManageDao;
	
	@Autowired
	private OSSClientUtil ossClient;
	
	@Autowired
	private ImageDetailDao imageDetailDao;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ManageImageDao manageImageDao;

	@Override
	public Integer insert(OthersManage t) {
		
		List<OthersManage> om = othersManageDao.findByTitle(t.getTitle());
		if(om.size()!=0){
			return -1;
		}else{
			othersManageDao.insert(t);
			if(t.getIds()!=null && t.getIds() != ""){
				String[] ids = t.getIds().split(",");
				for(String id:ids){
					ManageImages mi = new ManageImages();
					mi.setImageId(Integer.valueOf(id));
					mi.setManageId(t.getManageId());
					manageImageDao.insert(mi);
				}
			}
		}
		return t.getManageId();
	}

	@Override
	public Integer update(OthersManage t) {
		System.out.println(t.getIds());
		if(null != t.getIds() && "" != t.getIds()){
			String[] ids = t.getIds().split(",");
			for(String id:ids){
				if(!id.equals("undefined")){
					ManageImages mi = new ManageImages();
					mi.setImageId(Integer.valueOf(id));
					mi.setManageId(t.getManageId());
					manageImageDao.insert(mi);
				}
			}
		}
		return othersManageDao.update(t);
	}

	@Override
	public Integer delete(Integer id) {
		return null;
	}

	@Override
	public OthersManage findById(Integer id) {
		return othersManageDao.findById(id);
	}

	@Override
	public List<OthersManage> findListAll() {
		// TODO Auto-generated method stub
		return othersManageDao.findListAll();
	}

	@Override
	public WebPage<OthersManage> findPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return othersManageDao.findPage(map);
	}

	@Override
	public List<OthersManage> findListAllWithMap(Map<String, Object> paramsMap) {
		return othersManageDao.findListAllWithMap(paramsMap);
	}

	@Override
	public boolean existsEntity(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Integer insertImages(MultipartFile file) throws Exception{
		return imageService.insertImages(file);
	  }
	public ImagesDetail findImagesById(int id){
		return imageDetailDao.findById(id);
	}

}
