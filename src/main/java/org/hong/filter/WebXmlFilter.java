package org.hong.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by hong on 2017/3/21.
 */
public class WebXmlFilter implements Filter {

    private String msg;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
          this.msg=filterConfig.getInitParameter("msg");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行web.xml文件中配置的filter");
        System.out.println("获取到的初始化参数：msg="+msg);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
