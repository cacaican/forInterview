package com.xiaocai.ui.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring5.view.ThymeleafView;

import java.util.Locale;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/3/14 10:41
 */
public class ThymeleafViewResolver extends org.thymeleaf.spring5.view.ThymeleafViewResolver {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
//    private Integer expire = 0;

    public ThymeleafViewResolver() {
    }

//    public Integer getExpire() {
////        return this.expire;
//    }
//
//    public void setExpire(Integer expire) {
////        this.expire = expire;
//    }

    protected View loadView(String viewName, Locale locale) throws Exception {
        View view = super.loadView(viewName, locale);
        if (view instanceof ThymeleafView) {
            view = ((ThymeleafView)view);
        }

        return view;
    }
}
