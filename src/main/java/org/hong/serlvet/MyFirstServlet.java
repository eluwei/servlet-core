package org.hong.serlvet;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hong
 * @version v1.1
 * @ClassName: MyFirstServlet
 * @Description: (第一个servlet 事例)
 * @date 15:53
 */
public class MyFirstServlet extends HttpServlet {

    /**
     * 1.MyFirstServlet类继承了HttpServlet。这个继承是必须的，因为所有的Servlet必须是要么继承了 javax.servlet.GenericServlet 的普通Servlet，
     * 要么是继承了 javax.servlet.http.HttpServlet 的HTTP Servlet。
     * 2.web容器(web.xml)里注册上面的Servlet
     */


    private String message;


    /**
     * 每次服务器接收到一个 Servlet 请求时，服务器会产生一个新的线程并调用服务。
     * service() 方法检查 HTTP 请求类型（GET、POST、PUT、DELETE 等），并在适当
     * 的时候调用 doGet、doPost、doPut，doDelete 等方法。
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("2. /myFirstServlet --> service... ---> (get/post...)");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("servlet 调用 destroy 进行销毁");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        //初始化代码
        message = "Hello Servlet";

        System.out.println("1.项目启动后，servlet 调用init 进行初始化");
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyFirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet MyFirstServlet at " + req.getContextPath() + "</h2>");
            out.println("<h2>Servlet MyFirstServlet message " + message + " </h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
        super.doGet(req, resp);
}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
