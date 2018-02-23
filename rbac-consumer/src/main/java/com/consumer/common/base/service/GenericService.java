package com.consumer.common.base.service;


import com.base.common.QueryBase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
public interface GenericService<T, Q extends QueryBase> {

    /**
     * 功能描述：根据ID来获取数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> getById(@RequestParam("id") int id);


    /**
     * 功能描述：获取数据
     * @param entity
     * @return
     */
    @RequestMapping(value = "/get",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> get(@RequestBody T entity);

    /**
     * 功能描述：保存数据
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> save(@RequestBody T entity);

    /**
     * 功能描述：更新数据数据
     * @param entity
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> update(@RequestBody T entity);

    /**
     * 功能描述：实现删除数据
     * @param entity
     * @return
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> remove(@RequestBody T entity);


    /**
     * 功能描述：实现批量删除的记录
     * @param json
     * @return
     */
    @RequestMapping(value = "/removeBath",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> removeBath(@RequestParam("json") String json);

    /**
     * 功能描述：获取分页的数据
     * @param entity
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> list(@RequestBody Q entity);

    /**
     * 功能描述：判断当前的元素是否已经存在
     * @param entity
     * @return
     */
    @RequestMapping(value = "/isExist",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> isExist(@RequestBody Q entity);

}
