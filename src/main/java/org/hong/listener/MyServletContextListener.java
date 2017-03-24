package org.hong.listener;

import org.hong.serlvet.CodeServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EventListener;

/**
 * @author hong
 * @version v1.1
 * @ClassName: MyServletContextListener
 * @Description: (自定义listener)
 * @date 16:18
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        // 编程式添加 Servlet 到上下文对框架开发者是很有用的。例如，框架可以使用这个方法声明一个控制器
        // Servlet。这个方法将返回一个 ServletRegistration 或 ServletRegistration.Dynamic 对象，允许我们进一步配置
        // 如 init-params， url-mapping 等 Servlet 的其他参数。

        //手动添加listener
        context.addListener(CodeServletContextListener.class);

        //手动添加servlet
        ServletRegistration.Dynamic dynamic = context.addServlet("codeServlet", CodeServlet.class);
        dynamic.addMapping("/codeServlet");

        //手动添加filter
        FilterRegistration.Dynamic filterRegistration= context.addFilter("codeFilter","org.hong.filter.CodeFilter");
        filterRegistration.setInitParameter("msg","hello filter");
        filterRegistration.addMappingForUrlPatterns(null,false,"/codeServlet","/testCodeFilter");

        //给servlet 上下文设置上下文属性 (context.setAttribute()、context.getAttribute().....)
        context.setAttribute("name","zhangsan");

        //对资源的操作
        String path= context.getRealPath("/test.txt");

        System.out.println(path);



        System.out.println("监听我们的Servlet-core 启动");
        System.out.println("手动添加和配置了CodeServlet......");
        System.out.println("手动添加和配置了CodeFilter......");
        System.out.println("手动添加和配置了CodeListener......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
