package com.produce;

import com.base.util.redis.RedisCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RbacProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacProduceApplication.class, args);
	}

	/**
	 * 功能描述：注入redis
	 * @return
	 */
	@Bean
	public RedisCache redisCache(){
		return new RedisCache();
	}
}
