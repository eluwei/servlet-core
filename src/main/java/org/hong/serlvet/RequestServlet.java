package org.hong.serlvet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * @author hong
 * @version v1.1
 * @ClassName: RequestServlet
 * @Description: (主要用来测试 HttpServletRequest 对象的相关方法)
 * @date 15:25
 */
@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //>>> ServletRequest 接口的下列方法可访问这些参数：
        //1.req.getParameter 获取
        String name = req.getParameter("name");
        String url = req.getParameter("url");
        System.out.println("name:" + name + ",url:" + url);

        //2.req.getParameterNames
        Enumeration<String> enums = req.getParameterNames();
        int s = 0;
        while (enums.hasMoreElements()) {
            System.out.println("getParameterNames[" + s + "]......." + enums.nextElement());
            s++;
        }
        //3.req.getParameterValues(key) 返回一个 String 对象的数组，包含了与参数名称相关的所有参数值
        //  getParameter 方法的返回值必须是 getParameterValues 方法返回的 String 对象数组中的第一个值
        String[] names = req.getParameterValues("name");
        for (String value : names) {
            System.out.println("name:" + value);
        }

        //4.req.getParameterMap() getParameterMap 方法返回请求参数的一个 java.util.Map 对象，
        //  其中以参数名称作为 map 键，参数值作为 map 值。
        Map map = req.getParameterMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key;
            String value[];
            key = it.next().toString();
            value = (String[]) map.get(key);
            System.out.println(key);
            for (String s1 : value) {
                System.out.println(s1);
            }
        }

        //>>> request属性
        req.setAttribute("hello", "world");
        System.out.println(req.getAttribute("hello"));

        //>>> request 请求头（请求头主要信息http://tools.jb51.net/table/http_header）
        //可以通过一下方法获取请求头信息
        String cookie = req.getHeader("Cookie");
        System.out.println("cookie:" + cookie);
        Enumeration<String> cookies = req.getHeaders("Cookie");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println("headerName:" + headerNames.nextElement());
        }

        //>>> 请求路径元素
        //当前项目默认上下文 对应本项目/servlet-core
        String contextPath = req.getContextPath();
        //当前servlet 的映射地址 对应当前servlet 是/formServlet
        String servletPath = req.getServletPath();
        //其实是获取相对于当前servlet 的子路径，前提是有子路径的前台下
        //比如：servlet 的访问路径设置的是/servlet/*  , 如果访问路径为/servlet/info ，那么req.getPathInfo() 的值就为/info ,没有的话就是null
        String pathInfo = req.getPathInfo();
        //request.getRequestURI() 的返回值包含了 request.getContextPath()，所以是相对于网站的根目录的
        String requestURI = req.getRequestURI();
        System.out.println("contextPath:" + contextPath);
        System.out.println("servletPath:" + servletPath);
        System.out.println("pathInfo:" + pathInfo);
        System.out.println("requestURI:" + requestURI);

        //>>> Cookie
        req.getCookies();

        //>>> 国际化
        // req.getLocale() 返回客户端要接受内容的首选语言环境
        // req.getLocales() 将返回一个 Locale 对象的枚举，从首选语言环境开始顺序递减，这些语言环境是可被客户接受的语言环境。
        Locale locale = req.getLocale();
        System.out.println(locale.toString());

        //>>> 请求数据编码
        System.out.println(req.getCharacterEncoding());
        //果客户端没有设置字符编码，并使用不同的编码来编码请求数据，而不是使用上面描述的默认的字符编码 ，
        //那 么 可 能 会 发 生 破 坏 。 为 了 弥 补 这 种 情 况 ， ServletRequest 接 口 添 加 了 一 个 新 的 方 法
        //setCharacterEncoding(String enc)。开发人员可以通过调用此方法来覆盖由容器提供的字符编码。必须在解析
        //任何 post 数据或从请求读取任何输入之前调用此方法。
        req.setCharacterEncoding("UTF-8");


        ServletContext context = req.getServletContext();
        context.setAttribute("name",name);
        context.setAttribute("url",url);
        context.setAttribute("contextPath",contextPath);
        context.setAttribute("servletPath",servletPath);
        context.setAttribute("requestURI",requestURI);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/info.jsp");
        rd.forward(req, resp);
    }
}
