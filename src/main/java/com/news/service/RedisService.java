package com.news.service;

import org.springframework.stereotype.Service;

import com.news.entity.RedisKeyDto;

@Service
public interface RedisService {
	void addData(RedisKeyDto redisKeyDto);
    void delete(RedisKeyDto redisKeyDto);
    RedisKeyDto redisGet(RedisKeyDto redisKeyDto);
    void addRedisData(RedisKeyDto redisKeyDto,int outTime);
}
