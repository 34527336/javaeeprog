package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
*  4.创建Spring配置类SpringConfig，用@ComponentScan配置Spring容器管理的类，用@Import导入前面的配置类，用@EnableTransactionManagement开启事务支持功能
* */
@Configuration
@ComponentScan({"com.dao","com.service"})
//需要注意的是 SpringConfig 类最好采用 @Import 注解导入其它配置类，
// 不要将相关的配置方法写到SpringConfig这里，否则会出现无法获取配置信息的问题。
@Import({MyBatisConfig.class, JdbcConfig.class})
@EnableTransactionManagement
public class SpringConfig {

}
