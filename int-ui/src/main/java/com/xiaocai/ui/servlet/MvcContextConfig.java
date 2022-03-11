package com.xiaocai.ui.servlet;

import com.xiaocai.ui.converter.UTF8JsonHttpMessageConverter;
import com.xiaocai.ui.converter.UTF8StringHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * @description: @EnableWebMvc 注解用于集成spring mvc，使用该注解的方法需要继承WebMvcConfigurationSupport类
 * 参考文章：https://www.yisu.com/zixun/598601.html
 * @author: xiaocai
 * @time: 2022/3/11 14:49
 */
@Configuration
@EnableWebMvc
public class MvcContextConfig extends WebMvcConfigurationSupport {

/*WebMvcConfigurationSupport的中文注解：
    这是提供 MVC Java 配置背后的配置的主类。
    它通常通过将@EnableWebMvc 添加到应用程序@Configuration 类来导入。
    另一种更高级的选择是直接从此类扩展并根据需要覆盖方法，记住将@Configuration 添加到子类，将@Bean 添加到覆盖的@Bean 方法。
    有关更多详细信息，请参阅 @EnableWebMvc 的 javadoc。
    此类注册以下 HandlerMapping： RequestMappingHandlerMapping
    按 0 排序，用于将请求映射到带注释的控制器方法。
    HandlerMapping 按 1 排序，将 URL 路径直接映射到视图名称。
    BeanNameUrlHandlerMapping 排序为 2 以将 URL 路径映射到控制器 bean 名称。
    RouterFunctionMapping 按 3 排序以映射路由器功能。
    HandlerMapping 以 Integer.MAX_VALUE-1 排序以服务静态资源请求。
     HandlerMapping 以 Integer.MAX_VALUE 排序以将请求转发到默认 servlet。
     注册这些 HandlerAdapter： RequestMappingHandlerAdapter 用于处理带有注释控制器方法的请求。
     HttpRequestHandlerAdapter 用于使用 HttpRequestHandlers 处理请求。
     SimpleControllerHandlerAdapter 用于使用基于接口的控制器处理请求。
     HandlerFunctionAdapter 用于处理带有路由功能的请求。
     使用此异常解析器链注册 HandlerExceptionResolverComposite： ExceptionHandlerExceptionResolver
     用于通过 org.springframework.web.bind.annotation.ExceptionHandler 方法处理异常。
     使用 org.springframework.web.bind.annotation.ResponseStatus 注释的异常的 ResponseStatusExceptionResolver。
     用于解析已知 Spring 异常类型的 DefaultHandlerExceptionResolver 注册 AntPathMatcher 和 UrlPathHelper 以供以下用户使用：RequestMappingHandlerMapping、ViewControllers 的 HandlerMapping 和服务资源的 HandlerMapping
     请注意，这些 bean 可以使用 PathMatchConfigurer 进行配置。
      RequestMappingHandlerAdapter 和 ExceptionHandlerExceptionResolver 默认配置有以下默认实例： ContentNegotiationManager
      一个 DefaultFormattingConversionService
      一个 org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean
      如果 JSR-303 实现在类路径上可用 一系列 HttpMessageConverters 取决于第三个-party 库在类路径上可用
      。自：3.1 请参见：EnableWebMvc、WebMvcConfigurer 作者：Rossen Stoyanchev、Brian Clozel、Sebastien Deleuze
*/

    /*Spring Boot 中默认的静态资源配置，是把类路径下的/static、/public、/resources 和 /METAINF/resources 目录
    或者 ServletContext 的根目录中的静态文件直接映射为 /****。
    它使用来自 Spring MVC 的ResourceHttpRequestHandler，以便您可以通过添加自己的WebMvcConfigurer并覆盖addResourceHandlers方法来修改该行为*/
    //1.静态资源配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.setOrder(1).addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");//静态资源路径 css,js,img等
        registry.setOrder(2).addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");//视图
        registry.setOrder(3).addResourceHandler(new String[]{"/**/*.css"}).addResourceLocations(new String[]{"classpath:/web/"});

        //registry.addResourceHandler("/mapper/**").addResourceLocations("classpath:/mapper/");//mapper.xml
        super.addResourceHandlers(registry);
    }



    //2.拦截器配置
    //通过重写 addInterceptors() 方法，使用 InterceptorRegistry 注册类来添加拦截器 HandlerInterceptor。示例代码如下：
//    @Autowired
//    private BeforMethodInteceptor beforMethodInteceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(beforMethodInteceptor) //添加拦截器
//                .addPathPatterns("/**") //添加拦截路径
//                .excludePathPatterns(//添加排除拦截路径
//                        "/index",
//                        "/login",
//                        "/doLogin",
//                        "/logout",
//                        "/register",
//                        "/doRegister",
//                        "/**/*.css",
//                        "/**/*.png",
//                        "/**/*.jpeg",
//                        "/**/*.jpg",
//                        "/**/*.ico",
//                        "/**/*.js",
//                        "/swagger-resources/**"
//                );
//        super.addInterceptors(registry);
//    }

    //3.跨域配置
    //通过重写 addCorsMappings 方法实现跨域配置的支持，使用 CorsRegistry 注册类添加路径映射。示例代码如下：
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//配置允许跨域的路径
                .allowedOrigins("*")//配置允许访问的跨域资源的请求域名
                .allowedMethods("PUT,POST,GET,DELETE,OPTIONS")//配置允许访问该跨域资源服务器的请求方法，如：POST、GET、PUT、DELETE等
                .allowedHeaders("*"); //配置允许请求header的访问，如 ：X-TOKEN
        super.addCorsMappings(registry);
    }

    //4.视图控制器配置
    //通过重写 addViewControllers 方法，使用 ViewControllerRegistry 注册类来实现视图控制器配置。示例代码如下：
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");//默认视图跳转
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/article").setViewName("/article");
        registry.addViewController("/error/404").setViewName("/error/404");
        registry.addViewController("/error/500").setViewName("/error/500");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
    /*上面的代码等同于如下代码：
    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "index";
    }
    @RequestMapping(value = "article")
    public String article() {
        return "article";
    }
    @RequestMapping(value = "/error/404")
    public String error_404() {
        return "/error/404";
    }
    @RequestMapping(value = "/error/500")
    public String error_500() {
        return "/error/500";
    }*/

    //5.消息转换器配置
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //自定义字符串转换器：
        converters.add(new UTF8StringHttpMessageConverter());
        //自定义fastjson转换器：
        converters.add(new UTF8JsonHttpMessageConverter());
        /*
        converters.add(new AllEncompassingFormHttpMessageConverter());*/

       /*
       方法二
       StringHttpMessageConverter converter  = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(converter);
        //自定义fastjson转换器：
        super.configureMessageConverters(converters);
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //5.将convert添加到converters当中.
        converters.add(fastJsonHttpMessageConverter);*/
    }

        //6.数据格式化器配置
        @Override
        public void addFormatters(FormatterRegistry registry) {
            super.addFormatters(registry);
            registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
        }

        //7.视图解析器配置
        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("");
            viewResolver.setSuffix(".html");
            viewResolver.setCache(false);
            viewResolver.setContentType("text/html;charset=UTF-8");
            viewResolver.setOrder(0);
            registry.viewResolver(viewResolver);
            super.configureViewResolvers(registry);
        }


}
