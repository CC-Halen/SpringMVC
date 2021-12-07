package com.cdw.controller;

import com.cdw.domain.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author: cdw
 * @date: 2021/11/25 16:19
 * @description:
 */
@Controller
public class MyController {
    //定义方法，处理请求
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome() {
        //能处理请求的方法就是控制器方法，相当于doGet方法
        //调用service对象处理请求，返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "处理了some.do的请求");
        mv.addObject("fun", "执行了doSome方法");

        //通过视图解析器将路径拼接好
        mv.setViewName("show");

        //返回结果
        return mv;
    }


    @RequestMapping(value = "/other.do", method = RequestMethod.POST)
    public ModelAndView doOther() {
        //能处理请求的方法就是控制器方法
        //调用service对象处理请求，返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "处理了other.do的请求");
        mv.addObject("fun", "执行了doOther方法");


        //通过视图解析器将路径拼接好
        mv.setViewName("other");

        //返回结果
        return mv;
    }

    @RequestMapping(value = "/doParam.do", method = RequestMethod.POST)
    public ModelAndView doParam(HttpServletRequest req, String name, Integer age) {


        System.out.println(name);
        System.out.println(age);

        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);

        mv.setViewName("show");
        return mv;
    }


    @RequestMapping(value = "/doParam1.do", method = RequestMethod.POST)
    public ModelAndView doParam1(@RequestParam("rname") String name,
                                 @RequestParam("rage") Integer age) {


        System.out.println(name);
        System.out.println(age);

        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);

        mv.setViewName("show");
        return mv;
    }


    @RequestMapping(value = "/receive-object.do", method = RequestMethod.POST)
    public ModelAndView doReceive(Student student) {
        System.out.println(student);
        ModelAndView mv = new ModelAndView();

        mv.addObject("stu", student);

        mv.setViewName("show");
        return mv;
    }

    @RequestMapping("/some1.do")
    public String doSome1(HttpServletRequest req) {
        req.setAttribute("myname", "赵四");
        req.setAttribute("myage", 11);
        req.setAttribute("stu", new Student("小屁孩", 1));

        return "show";
    }


    @RequestMapping("/return-void-ajax.do")
    public void returnVoidAjax(String name, Integer age, HttpServletResponse resp) throws IOException {
        System.out.println(name + " " + age);
        Student student = new Student(name, age);

        //对象转换为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        System.out.println(json);

        //输出json，响应ajax
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();

    }


    /**
     * 控制器方法返回Student--json
     */
    @RequestMapping("/doStudentJson.do")
    @ResponseBody
    public Student doAjaxJson(String name, Integer age) {
        System.out.println("控制器方法返回自定义对象student，转为json");
        Student student = new Student(name, age);
        System.out.println(student);
        return student;
    }

    /**
     * 控制器方法返回Student--json array
     *
     * @return
     */
    @RequestMapping("/doStudentJsonArray.do")
    @ResponseBody
    public ArrayList<Student> doAjaxJsonArray(String name, Integer age) {
        System.out.println("控制器方法返回自定义对象List<Student>");
        Student student = new Student(name, age);
        Student student1 = new Student("李四", 35);

        ArrayList<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        return list;
    }


    /**
     * 有@ResponseBody，就是数据，没有就是视图
     * ajax中的响应乱码问题要使用RequestMapping的produces属性设置编码方式
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/doStringData.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name, Integer age) {
        System.out.println(name + age);
        return "Hello SpringMVC注解开发";
    }




}