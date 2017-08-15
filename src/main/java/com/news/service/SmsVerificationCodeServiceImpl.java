package com.news.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.news.common.SMSUtils;
import com.news.entity.RedisKeyDto;

@Service
public class SmsVerificationCodeServiceImpl implements SmsVerificationCodeService{

	
	private static Logger LOGGER = LoggerFactory.getLogger(SmsVerificationCodeService.class);
	
	@Autowired
	RedisServiceImpl redisService;

	
	@Transactional
	@Override
	public String sendMessage(String phoneName) {
		SMSUtils smsu = new SMSUtils();
		String returnCode="";
		try {
			String checkCode = smsu.sendMsgCode(phoneName);
			RedisKeyDto cc = new RedisKeyDto();
			cc.setKeys(phoneName);
			cc.setValues(checkCode);
			RedisKeyDto exsitCC = redisService.redisGet(cc);
			if(exsitCC != null){
				redisService.delete(exsitCC);
			}
			redisService.addRedisData(cc, 60000);
			returnCode = checkCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnCode;
	}

	@Override
	public boolean checkIsCorrectCode(String phone, String checkcode) {
		RedisKeyDto cc = new RedisKeyDto();
		cc.setKeys(phone);
		cc.setValues(checkcode);
		RedisKeyDto cc2 = redisService.redisGet(cc);
		if(cc2!=null && cc2.getValues().equals(checkcode)){/////////////////////*********/+
			return true;
		}
		return false;
	}
	
	
	
}
