package com.xiaocai.ui.servlet;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
        System.out.println("XiaocaiServlet 调用父类DispatcherServlet的doDispatch方法");

    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("XiaocaiServlet 被初始化");
    }

    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("XiaocaiServlet 未找到handler");
    }
}
