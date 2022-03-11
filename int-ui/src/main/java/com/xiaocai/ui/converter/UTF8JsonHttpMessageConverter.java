package com.xiaocai.ui.converter;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.Charset;

public class UTF8JsonHttpMessageConverter extends MappingJackson2HttpMessageConverter {
    public UTF8JsonHttpMessageConverter() {
    }
}