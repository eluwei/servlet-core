package org.hong.serlvet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: DynamicServlet
 * @Description: (使用ServletContainerInitializer 注册servlet)
 * @author hong
 * @date 2017/3/22
 * @version v1.1
 */
public class DynamicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这个一个通过ServletContainerInitializer 注册的servlet");

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/include.jsp");
        //注：forward方法是把请求的内容转发到另外的一个servlet.而include是把另一个servlet处理过后的内容拿过来.
        rd.include(req,resp);
    }
}
