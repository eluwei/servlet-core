package org.hong.serlvet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by hong on 2017/5/19.
 */
/** 必须在一个请求涉及的所有Servlet及Filter中都声明asyncSupported=true。 **/
@WebServlet(name="asyncServlet",urlPatterns ={"/asyncServlet"},asyncSupported = true)
public class AsyncServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = null;
        resp.setContentType("text/html;charset=UTF-8");

        try {
            out = resp.getWriter();
            out.print("servlets starts:" + new Date() + "<br>");
            out.flush();

            //启动 serlvet 异步
            AsyncContext asyncContext = req.startAsync();
            asyncContext.setTimeout(50000);

            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent asyncEvent) throws IOException {
                    //将流在这里关闭
                    asyncEvent.getSuppliedResponse().getWriter().close();
                    System.out.println("asynContext finished....");
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {

                }

                @Override
                public void onError(AsyncEvent event) throws IOException {

                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {

                }
            });
            new Thread(new Mythread(asyncContext)).start();

            out.print("servlets ends:"+new Date()+"<br>");
            out.flush();
        }catch (Exception e){

        }finally {

        }
    }
}
