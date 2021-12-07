package com.cdw.handler;

import com.cdw.exception.AgeException;
import com.cdw.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: cdw
 * @date: 2021/11/27 20:05
 * @description:
 * @ControllerAdvice 表示当前类是一个异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //定义异常处理方法


    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception e) {
        System.out.println(e);
        ModelAndView mv = new ModelAndView();

        mv.addObject("tips", "名字只能是赵四");
        mv.setViewName("nameError");

        return mv;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception e) {
        System.out.println(e);
        ModelAndView mv = new ModelAndView();

        mv.addObject("tips", "年龄不能大于100");
        mv.setViewName("ageError");
        return mv;
    }

    @ExceptionHandler
    public ModelAndView doOtherException(Exception e) {
        System.out.println(e);
        ModelAndView mv = new ModelAndView();

        mv.addObject("tips", "请稍后尝试");
        mv.setViewName("defaultError");
        return mv;
    }
}
