package com.xiaocai.ui.controller.impl;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/3/11 17:14
 */
public class TemplateControllerImpl extends AbstractController {

    public TemplateControllerImpl() {
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = request.getServletPath();
        String viewName = path.substring(1);
        return new ModelAndView(viewName);
    }
}
