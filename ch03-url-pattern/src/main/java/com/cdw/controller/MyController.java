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
    @RequestMapping(value = "/some.do", method = RequestMethod.POST)
    public ModelAndView doSome(String name,Integer age) {
        //能处理请求的方法就是控制器方法，相当于doGet方法
        //调用service对象处理请求，返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage",age);

        //通过视图解析器将路径拼接好
        mv.setViewName("show");

        //返回结果
        return mv;
    }



}