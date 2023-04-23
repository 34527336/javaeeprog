package com.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;

/*
* 5.创建初始化类ServletInit，代替web.xml，配置让项目启动时加载SpringConfig配置、SpringMvcConfig配置，配置springmvc的路径拦截，同时解决response数据的中文乱码，及PUT，DELETE请求问题*/
public class ServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //指定spring的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    //指定SpringMVC的配置类

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    //指定DispatcherServlet的映射规则，即url-pattern，也即配置springmvc的路径拦截（ServletMapping）
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //解决response数据的中文乱码，及PUT，DELETE请求问题
    @Override
    protected Filter[] getServletFilters() {
        //解决response数据的中文乱码问题
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceRequestEncoding(true);
        //解决除POST，GET以外的PUT，DELETE等请求问题
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{encodingFilter, hiddenHttpMethodFilter};
    }

}
