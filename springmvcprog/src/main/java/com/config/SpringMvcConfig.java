package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/*
* 1.配置SpringMvcConfig类
* @Configuration 配置SpringMvcConfig配置类纳入Spring配置容器
* @ComponentScan("com.controller") 配置Spring MVC扫描的controller包
* @EnableWebMvc 开启Spring MVC的核心组件提供的能力，同时支持自定义Spring MVC配置的能力*/
@Configuration
/*
7.把SpringMvcSupport类让SpringMVC能扫描识别到
*/
@ComponentScan({"com.controller", "com.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
