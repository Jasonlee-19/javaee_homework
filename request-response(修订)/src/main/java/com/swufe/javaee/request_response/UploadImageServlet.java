package com.swufe.javaee.request_response;

import com.sun.deploy.cache.Cache;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import org.apache.commons.lang.StringUtils;
import jdk.nashorn.internal.objects.Global;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet(urlPatterns = "/uploadImage")
@MultipartConfig(location = "C:\\Users\\13045\\Desktop\\image",maxFileSize = 10*1024*1024)
public class UploadImageServlet extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置处理编码
        request.setCharacterEncoding("UTF-8");
        Part imagePart = request.getPart("filename");//取得imagePart对象
        //获得文件名字
        String fileName = getFilename(imagePart);
        imagePart.write(fileName);
        //返回页面消息
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("You have upload the image successfully!");
        out.close();

    }
    //获取文件名称
    private String getFilename(Part imagePart){
        if(imagePart == null)
            return null;
        String fileName = imagePart.getHeader("content-dispotion");
        if(StringUtils.isBlank(fileName)){
            return null;
        }
        return StringUtils.substringBetween(fileName,"filename=\"","\"");
    }
}

