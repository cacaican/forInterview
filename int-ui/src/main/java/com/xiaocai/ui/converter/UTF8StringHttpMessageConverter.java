package com.xiaocai.ui.converter;

import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/3/11 16:05
 */
public class UTF8StringHttpMessageConverter extends StringHttpMessageConverter {
    public UTF8StringHttpMessageConverter() {
        super(Charset.forName("UTF-8"));
    }
}
