package com.consumer.sys.controller;

import com.base.entity.Dict;
import com.base.entity.QueryDict;
import com.consumer.common.base.controller.GenericController;
import com.consumer.common.base.service.GenericService;
import com.consumer.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
* 类描述：
* @auther linzf
* @create 2018/1/30 0030 
*/
@RestController
@RequestMapping("/dict")
public class DictController  extends GenericController<Dict,QueryDict> {

    @Autowired
    private DictService dictService;

    @Override
    protected GenericService<Dict, QueryDict> getService() {
        return dictService;
    }

    /**
     * 功能描述：将字典数据初始化到前端js中
     * @return
     */
    @RequestMapping(value = "/loadDict",method = RequestMethod.POST)
    public Map<String,Object> loadDict(){
        return dictService.loadDict();
    }
}
