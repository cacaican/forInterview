package com.xiaocai.ui.controller.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/3/11 17:14
 */
@Component
public class TemplateControllerImpl extends AbstractController {

    public TemplateControllerImpl() {
        System.out.println(this.getClass().getName()+"被初始化");
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //默认的获取不到servlet路径
        String path = request.getServletPath();
        String viewName = path.substring(1);

        System.out.println(this.getClass().getName()+"处理内部请求");
        return new ModelAndView(viewName);
    }
}
