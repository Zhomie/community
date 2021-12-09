package com.homie.community.Controller;

import com.homie.community.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("testalpha")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/testgetdata")
    @ResponseBody
    /*@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器
      转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据
      或者是XML数据*/
    public String testgetdata(){
        return testService.testfind();
    }

    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name="current",required = false,defaultValue = "1") int current,
            @RequestParam(name= "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some student";
    }

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id ){
        System.out.println(id);
        return "a student";
    }

    //POST请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应一个HTML数据
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    //不用@ResponseBody注解
    public String getschool(Model model){
            model.addAttribute("name","哈尔滨理工大学");
            model.addAttribute("age",70);
            //指向了resources里的templates的demo目录里面的view.html
        return "/demo/view";
    }


    //返回JSON数据（异步请求）

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getemps(){
            List<Map<String,Object>> list  = new ArrayList<>();
            Map<String,Object> emp = new HashMap<>() ;
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "李四");
        emp.put("age", 24);
        emp.put("salary", 9000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "王五");
        emp.put("age", 25);
        emp.put("salary", 10000.00);
        list.add(emp);

        return list;
    }
}
