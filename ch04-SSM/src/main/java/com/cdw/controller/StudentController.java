package com.cdw.controller;

import com.cdw.domain.Student;
import com.cdw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: cdw
 * @date: 2021/11/27 15:07
 * @description:
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView mv = new ModelAndView();

        String msg = "注册失败！！";
        int res = service.addStudent(student);
        if (res > 0)
            msg = "注册成功";
        mv.addObject("msg", student.getName() + msg);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> showStudent() {
        List<Student> students = service.queryStudents();
        return students;
    }
}
