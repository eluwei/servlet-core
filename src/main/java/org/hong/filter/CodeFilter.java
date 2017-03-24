package org.hong.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by hong on 2017/3/16.
 */
public class CodeFilter implements Filter {

    private String msg;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        msg= filterConfig.getInitParameter("msg");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("手动添加和配置filter 实例...... msg:"+msg);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
