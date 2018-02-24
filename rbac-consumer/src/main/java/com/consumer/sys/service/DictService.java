package com.consumer.sys.service;

import com.base.entity.Dict;
import com.base.entity.QueryDict;
import com.consumer.common.base.service.GenericService;
import com.consumer.common.config.FullLogConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
@FeignClient(value="RBAC-PRODUCE",configuration = FullLogConfiguration.class,path = "/dict")
public interface DictService extends GenericService<Dict,QueryDict> {

    /**
     * 功能描述：将字典数据初始化到前端js中
     * @return
     */
    @RequestMapping(value = "/loadDict",method = RequestMethod.POST)
    Map<String,Object> loadDict();



}
