package org.hong.initializer;

import org.hong.serlvet.DynamicServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * @author hong
 * @version v1.1
 * @ClassName: MyServletContainerInitializer
 * @Description: (自定义servlet 初始化程序)
 * @date 2017/3/22
 */
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        ServletRegistration.Dynamic dynamic = ctx.addServlet("dynamicServlet", DynamicServlet.class);
        dynamic.addMapping("/dynamicServlet");

        //通过注册的servlet名称，添加mapping地址
        ctx.getServletRegistrations().get("dynamicServlet").addMapping("/dynamicServlet/*");
        System.out.println("......MyServletContainerInitializer.");

    }
}
