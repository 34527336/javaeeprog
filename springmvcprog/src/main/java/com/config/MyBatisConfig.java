package com.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
/*
* 3.创建MyBatisConfig类，在该类中创建sqlSessionFactoryBean，创建mapperScannerConfigurer实例bean扫描并自动生成代理对象
* */
public class MyBatisConfig {
    //创建sqlSessionFactoryBean实例让Spring托管,使用 MyBatis-Spring 之后, 会使用SqlSessionFactoryBean来代替SqlSessionFactoryBuilder创建SqlSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
    //创建mapperScannerConfigurer实例bean，并设置mybatis的包扫描路径，mapperScannerConfigurer将会查找类路径下的映射器并自动将它们创建成MapperFactoryBean
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.dao");
        return mapperScannerConfigurer;
    }
}
