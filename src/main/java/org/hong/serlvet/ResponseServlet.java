package org.hong.serlvet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: ResponseServlet
 * @Description: (主要是用来测试response 的主要api)
 * @author hong
 * @date 10:30
 * @version v1.1
 */
@WebServlet("/responseServlet")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.response常用API
//        setStatus：设置响应行当中的状态码
//        setHeader：设置响应头信息
//        getOutputStream：获得字节流 --- 输出响应体内容
//        getWriter：获得字符流 --- 输出响应体内容
//        2.HttpServletResponse继承ServletResponse接口，ServletResponse并没有提供与HTTP协议相关API，HttpServletResponse添加了与协议相关API
//        JavaEE API 中并没有提供HttpServletResponse实现类---实现类由tomcat服务器提供的
//        3.常用状态码：200 302 304 404 500
//        200 请求处理成功
//        302 客户端重定向
//        304 客户端访问资源没有被修改，客户端访问本地缓存
//        404 访问资源不存在
//        500 服务器内部出错

        //302客户端重定向 --- 结合Location头信息一起使用
        System.out.println("response。。。。。。。。。。。。");
        resp.setStatus(302);
        //通知浏览器定向到哪个页面
        resp.setHeader("Location", "index.jsp");


        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
