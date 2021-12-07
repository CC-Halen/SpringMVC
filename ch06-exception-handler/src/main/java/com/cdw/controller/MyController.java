package com.cdw.controller;

import com.cdw.exception.AgeException;
import com.cdw.exception.MyException;
import com.cdw.exception.NameException;
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
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyException {

        if (!"赵四".equalsIgnoreCase(name))
            throw new NameException("姓名不正确");

        if (age == null || age.intValue() > 100)
            throw new AgeException("年龄太大了");
        //能处理请求的方法就是控制器方法，相当于doGet方法
        //调用service对象处理请求，返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);

        //通过视图解析器将路径拼接好
        mv.setViewName("show");

        //返回结果
        return mv;
    }

}