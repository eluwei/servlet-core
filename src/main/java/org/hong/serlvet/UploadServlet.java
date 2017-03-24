package org.hong.serlvet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version v1.1
 * @ClassName: MultipartConfigServlet
 * @Description: 上传文件的Servlet类
 */
@WebServlet("/upload")
//说明该Servlet处理的是multipart/form-data类型的请求
@MultipartConfig
public class UploadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置输入的请求信息采用UTF-8的编码方式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //输出流
        PrintWriter out = resp.getWriter();

        //Servlet3.0以后引入的新方法，用来处理multipart/form-data类型编码的表单
        Part part = req.getPart("file");
        //获取HTTP头信息headerInfo=（form-data; name="file" filename="文件名"）
        String headerInfo = part.getHeader("content-disposition");
        //从HTTP头信息中获取文件名fileName=（文件名）
        String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);

        //获得存储上传文件的文件夹路径
        String fileSavingFolder = this.getServletContext().getRealPath("/upLoad");
        //获得存储上传文件的完整路径（文件夹路径+文件名）
        //文件夹位置固定，文件夹采用与上传文件的原始名字相同
        String fileSavingPath = fileSavingFolder + File.separator + fileName;
        //如果存储上传文件的文件夹不存在，则创建文件夹
        File f = new File(fileSavingFolder + File.separator);
        if(!f.exists()){
            f.mkdirs();
        }
        //将上传的文件内容写入服务器文件中
        //这里我们是直接写到本地的文件夹中，实际项目中，我们可以使用像ftp 工具上传到服务器
        //其实到这里了，实际上操作的就是输入流part.getInputStream()
        part.write(fileSavingPath);

        //输出上传成功信息
        out.println("文件上传成功~！");
        out.flush();
        out.close();

        super.doPost(req, resp);
    }
}
