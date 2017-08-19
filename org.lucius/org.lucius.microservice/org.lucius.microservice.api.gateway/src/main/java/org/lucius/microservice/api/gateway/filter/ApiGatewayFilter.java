package org.lucius.microservice.api.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.lucius.commons.utils.JsonUtils;
import org.lucius.commons.utils.model.Result;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ApiGatewayFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("Api-Token");
        if(StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
            	Result<Object> result = new Result<Object>();
            	result.setResultCode("API-GATEWAY-00010001");
            	result.setResultMsg("用户未登录，请先登录");
                ctx.getResponse().getWriter().write(JsonUtils.toJson(result));
            }catch (Exception e){}

            return null;
        }
        return null;
    }

}
