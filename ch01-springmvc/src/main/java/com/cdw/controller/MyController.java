package com.cdw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: cdw
 * @date: 2021/11/25 16:19
 * @description:
 */
@Controller
public class MyController {
    //定义方法，处理请求

    /**
     * spring mvc 框架，使用控制器类的方法处理请求
     * 方法特点：
     * 1.方法形参，表示请求中的参数
     * 2.方法的返回值，表示本次请求的处理请求
     */

    /**
     * @return
     * @RequestMapping: 请求映射
     */

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome() {
        //能处理请求的方法就是控制器方法，相当于doGet方法
        //调用service对象处理请求，返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "处理了some.do的请求");
        mv.addObject("fun", "执行了doSome方法");

        //指定展示视图
//        mv.setViewName("/WEB-INF/view/show.jsp");
//        mv.setViewName("/WEB-INF/view/other.jsp");

        //通过视图解析器将路径拼接好
        mv.setViewName("show");

        //返回结果
        return mv;
    }


    @RequestMapping(value = {"/other.do","/second.do"})
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
}
