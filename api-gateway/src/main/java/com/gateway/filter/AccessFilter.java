package com.gateway.filter;

import com.base.entity.Identify;
import com.base.util.ip.IPUtil;
import com.gateway.service.AuthenticationService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/*
* 类描述：
* @auther linzf
* @create 2017/12/22 0022 
*/
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * filterType: 过滤器的类型， 它决定过滤器在请求的哪个生命周期中执行。 这里定义为pre, 代表会在请求被路由之前执行。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder: 过滤器的执行顺序。 当请求在一个阶段中存在多个过滤器时， 需要根据该方法返回的值来依次执行。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter: 判断该过滤器是否需要被执行。 这里我们直接返回了true, 因此该过滤器对所有请求都会生效。 实际运用中我们可以利用该函数来指定过滤器的有效范围。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * 这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求， 不对其进行路由， 然后通过 ctx.setResponseStatusCode
     *(401)设置了其返回的错误码， 当然也可以进 一步优化我们的返回， 比如，通过ctx.se七ResponseBody(body)对返回的body内容进行编辑等。
     * @return
     */
    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response= ctx.getResponse();
        // 设置允许跨域访问Access-Control-Allow-Origin设置的为当前dinner工程的IP+端口
        response.setHeader("Access-Control-Allow-Headers", "Authentication");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));

        log.info("send {} request to{}", request.getMethod () ,request.getRequestURL().toString()+"--"+ request.getContentType());

        Object accessToken = request.getParameter("token");
         if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            // 401错误表示需要登陆才可以
            ctx.setResponseStatusCode(401);
            //为了被error过滤器捕获
            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception",new RuntimeException("AccessToken不允许为空！"));
            throw new RuntimeException("AccessToken不允许为空！");
        }
        Map<String,Object> result = authenticationService.identify(new Identify((String)accessToken, IPUtil.getIpAddress(request)));
        log.info("鉴权中心鉴定结果是：", result.get("msg"));
         if((boolean)result.get("result")==false){
             ctx.setSendZuulResponse(false);
             // 401错误表示需要登陆才可以
             ctx.setResponseStatusCode(401);
             //为了被error过滤器捕获
             ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
             ctx.set("error.exception",new RuntimeException((String)result.get("msg")));
             throw new RuntimeException((String)result.get("msg"));
         }

        return null;
    }
}
