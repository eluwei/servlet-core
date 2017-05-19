package org.hong.serlvet;

import javax.servlet.AsyncContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 自定义异步serlvet 线程
 * Created by hong on 2017/5/19.
 */
public class Mythread implements Runnable {

    private AsyncContext asyncContext;
    private PrintWriter out;


    public Mythread(AsyncContext asyncContext){
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(10000);

            out = asyncContext.getResponse().getWriter();
            out.println("myTask starts:" + new Date() + "<br>");
            out.flush();

            out.print("myTask ends:" + new Date() + "<br>");
            out.flush();
            asyncContext.complete();
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {

			/*if(null != out){
                out.close();
				out = null;
			}*/
        }
    }
}
