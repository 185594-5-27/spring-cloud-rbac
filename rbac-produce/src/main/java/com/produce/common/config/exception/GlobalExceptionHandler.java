package com.produce.common.config.exception;


import com.produce.common.base.constant.SystemStaticConst;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：错误捕获异常处理类，当出现报错的时候将错误数据用json的形式返回给页面。
 */
@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public Map<String, Object> sqlExceptionHelper(HttpServletRequest req, SQLException e){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
        returnMap.put(SystemStaticConst.MSG,e.getMessage());
        return returnMap;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> handleGlobalException(HttpServletRequest req, Exception e){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
        returnMap.put(SystemStaticConst.MSG,e.getMessage());
        return returnMap;
    }

    @ExceptionHandler(value = ClientAbortException.class)
    public void handleGlobalClientAbortException(HttpServletRequest req, ClientAbortException e){
        //System.out.println("------------socket断开连接-------------"+e.getLocalizedMessage());
        System.out.println("------------socket断开连接-------------"+e.getLocalizedMessage());
    }

}
