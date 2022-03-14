package com.xiaocai.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public interface StuController {

    @ResponseBody
    @RequestMapping(value = "/getStudent" ,method = RequestMethod.POST)
    String getStudent(String name);

    @ResponseBody
    @RequestMapping(value = "/getStudent2" ,method = RequestMethod.POST)
    String getStudent2(String name);
}
