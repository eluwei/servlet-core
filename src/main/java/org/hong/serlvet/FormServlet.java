package org.hong.serlvet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hong
 * @version v1.1
 * @ClassName: FormServlet
 * @Description: (Servlet 以get方式获取表单数据)
 * @date 17:15
 */
@WebServlet(name = "formServlet", urlPatterns = {"/formServlet"}, initParams = {@WebInitParam(name = "msg", value = "hello formServlet")})
public class FormServlet extends HttpServlet {

    /**
     * @WebServlet 标记一个继承了HttpSerlvet 的类为Servlet .
     * name
     */


    private String msg;

    @Override
    public void init() throws ServletException {
        //初始化参数
        msg = this.getInitParameter("msg");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String url = req.getParameter("url");
        PrintWriter out = resp.getWriter();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyFirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet MyFirstServlet at " + name + "</h2>");
            out.println("<h2>Servlet MyFirstServlet message " + url + " </h2>");
            out.println("<h2>Servlet MyFirstServlet message " + msg + " </h2>");
            out.println("</body>");
            out.println("</html>");
            out.flush();
        }finally{
            out.close();
        }
        super.doGet(req, resp);
    }
}
