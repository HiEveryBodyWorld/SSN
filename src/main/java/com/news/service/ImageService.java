/**
 * 
 */
package com.news.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.news.common.OSSClientUtil;
import com.news.common.WebPage;
import com.news.dao.ImageDao;
import com.news.dao.ImageDetailDao;
import com.news.dao.UploadImageDao;
import com.news.entity.ImageTransfer;
import com.news.entity.Images;
import com.news.entity.ImagesDetail;
import com.news.entity.UploadImages;

/**
 * @author dell
 *
 */
@Service
public class ImageService {
	
	@Autowired
	private OSSClientUtil ossClient;
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private ImageDetailDao imageDetailDao;
	
	@Autowired
	private UploadImageDao uploadImageDao;
	
	public Integer insert(ImageTransfer model) {
		
		Images images = new Images();
		images.setDescription(model.getDescription());
		images.setCreateTime(new Date());
		images.setCreator(model.getCreator());
		images.setCreatorId(model.getCreatorId());
		images.setSpaceId(model.getSpaceId());
		imageDao.insert(images);
		
		String[] ids=model.getIds().split(",");
		
		for (int i = 0; i < ids.length; i++){
			UploadImages  uploadImages = new UploadImages();
			
			uploadImages.setImageId(Integer.parseInt(ids[i]));
			uploadImages.setUploadId(images.getId());
			
			uploadImageDao.insert(uploadImages);
		}
		return images.getId();
		
	}

	public Integer insertImages(MultipartFile file) throws Exception{
	    if (file == null || file.getSize() <= 0) {
	      throw new Exception("图片不能为空");
	    }
	    
	    String name = ossClient.uploadImg2Oss(file);
	    String imgUrl = ossClient.getImgUrl(name);
	    
	    ImagesDetail imageDetail = new ImagesDetail();
	    
	    imageDetail.setUrl(imgUrl);
	    imageDetail.setName(name);
	    
	    imageDetailDao.insert(imageDetail);//只是本地上传使用的
	    return imageDetail.getId();
	  }
	
	public Integer deleteUpload(Images images) throws Exception{
	    
	    return imageDao.update(images);
	  }
	
    public Integer deleteImages(String ids) throws Exception{
    	
       String[] imagesIds=ids.split(",");
		
		for (int i = 0; i < imagesIds.length; i++){
			ImagesDetail  imagesDetail = new ImagesDetail();
			
			imagesDetail.setId(Integer.parseInt(imagesIds[i]));
			
			imagesDetail.setIsDel(1);
			
			imageDetailDao.update(imagesDetail);
		}
	    
	    return 1;
	  }
	
	public WebPage<Images> findPage(Map<String, Object> map) {
		return this.imageDao.findPage(map);
	}
	
	public List<ImagesDetail> findImagesById(Integer id) {
		return this.imageDetailDao.findListById(id);
	}
	public ImagesDetail findById(Integer id) {
		return this.imageDetailDao.findById(id);
	}
	
}
