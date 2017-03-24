package org.hong.serlvet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hong on 2017/3/16.
 */
public class CodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        String name = (String) context.getAttribute("name");

        System.out.println("手动添加和配置servlet 实例.");
        System.out.println("获取到Listener 设置到ServletContext attribute的值为:"+name);

        resp.sendRedirect("index.jsp");
    }
}
