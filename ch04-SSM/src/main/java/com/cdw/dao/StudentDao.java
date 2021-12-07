package com.cdw.dao;

import com.cdw.domain.Student;

import java.util.List;

/**
 * @author: cdw
 * @date: 2021/11/27 14:46
 * @description:
 */
public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectStudents();
}
