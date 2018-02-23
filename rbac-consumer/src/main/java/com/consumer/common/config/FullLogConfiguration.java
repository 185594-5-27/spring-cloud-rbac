package com.consumer.common.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* 类描述：设置获取日志的级别为全部日志
* @auther linzf
* @create 2017/12/22 0022 
*/
@Configuration
public class FullLogConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        // • NONE: 不记录任何信息。
        // • BASIC: 仅记录请求方法、URL以及响应状态码和执行时间。
        // • HEADERS: 除了记录BASIC级别的信息之外， 还会记录请求和响应的头信息。
        // • FULL: 记录所有请求与响应的明细， 包括头信息、 请求体、 元数据等。
        return Logger.Level.FULL;
    }

}
