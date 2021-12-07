package com.cdw.service;

import com.cdw.domain.Student;

import java.security.PrivateKey;
import java.util.List;

/**
 * @author: cdw
 * @date: 2021/11/27 14:50
 * @description:
 */
public interface StudentService {
    int addStudent(Student student);

    List<Student> queryStudents();
}
