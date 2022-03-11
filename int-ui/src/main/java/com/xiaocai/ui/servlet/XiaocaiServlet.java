package com.xiaocai.ui.servlet;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 自定义的servlet
 * @author: xiaocai
 * @time: 2022/3/11 15:21
 */
public class XiaocaiServlet extends DispatcherServlet {

    public XiaocaiServlet() {
    }

    @Override
    public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doDispatch(request,response);
    }
}
