package com.xiaocai.test.service.impl;

import com.xiaocai.test.service.StudentService;
import org.springframework.stereotype.Service;
import com.xiaocai.test.entity.Student;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/3/11 16:41
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getStu(String name) {
        Student student = new Student();
        student.setName("xiaocai");
        student.setSex("boy");

        return student;
    }
}
