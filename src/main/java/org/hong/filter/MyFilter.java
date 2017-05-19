package org.hong.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hong on 2017/3/16.
 */
@WebFilter(filterName = "myFilter", urlPatterns = {"/servlet"}, initParams = {@WebInitParam(name = "name", value = "hello filter")})
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String name = filterConfig.getInitParameter("name");
        String value = filterConfig.getInitParameter("value");
        System.out.println("获取到的filter 初始化值为：name="+name +",value"+value);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("filter1===" + httpServletRequest.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
