package com.cdw.service.impl;

import com.cdw.dao.StudentDao;
import com.cdw.domain.Student;
import com.cdw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: cdw
 * @date: 2021/11/27 14:51
 * @description:
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;

    @Override
    public int addStudent(Student student) {
        int res = dao.insertStudent(student);
        return res;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = dao.selectStudents();
        return students;
    }
}
