package com.xiaocai.test.controller.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaocai.test.controller.StuController;
import com.xiaocai.test.service.StudentService;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/3/11 16:36
 */
@Component
@RequestMapping("/stu")
public class StuControllerImpl implements StuController {

    @Autowired
    private StudentService studentService;

    @Override
    @RequestMapping(value = "/getStudent" ,method = RequestMethod.POST)
    public String getStudent(String name) {
        //mvc中的参数匹配原则


        if (StringUtils.isBlank(name)) {
            return null;
        }
        return studentService.getStu(name).toString();
    }
}
