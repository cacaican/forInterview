#基于springboot构建自己的底层框架
##1.创建一个多模块项目forInterview，创建三个子模块int-base（基础框架，集成其他框架），int-web(用于部署到服务器)，int-ui处理前端请求。int-serviceice

##2.取消springboot的默认启动，
##3.int-web项目中定义web资源（web。xml）,web.xml文件中定义web服务器需要的配置，例如dispatherServlet，其他项目需要实例化的bean、过滤器、监听器