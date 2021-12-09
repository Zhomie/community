package com.homie.community.Controller;

import com.homie.community.Service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/data")
    @ResponseBody
    public String  getData(){
        return alphaService.find();
    }
    @RequestMapping("/hello")
    @ResponseBody
    public  String sayhello(){
        return "Hello Spring boot";
    }

    @RequestMapping("/http")
    public void testhttp(HttpServletRequest request , HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+"::"+value);
        }
        System.out.println(request.getParameter("code"));


        // 设置响应数据的类型是html文本，并告知浏览器用UTF-8解读。
        response.setContentType("text/html;charset = utf-8");

        try (
                //getWriter以字符流输出
                //
                //java.io.PrintWriter
                //具有自动行刷新的缓冲字符输出流，特点是可以按行写出字符串，并且可以自动行刷新。
                PrintWriter witer = response.getWriter();
                ){
            witer.write("<h1>张homie</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
