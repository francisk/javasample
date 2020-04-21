package com.baidu.dof.test;
import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractTestClass {
    @Value("${spring.datasource.username}")
    protected String dbUser;
    @Value("${spring.datasource.password}")
    protected String dbPassword;
    @Value("${spring.datasource.url}")
    protected String dbUrl;
    @Value("${spring.datasource.driver-class-name}")
    protected String dbDriver;

    protected String insertUser = "INSERT INTO `dbusers`(id,name,email,password) VALUES (1,'Tom','tom01@baidu.com','12345'),"
    + "(2,'jinrui02','jinrui01@baidu.com','12345'),"
    + "(3,'chenxiaosheng','chenxiaosheng@baidu.com','12345'),"
    + "(4,'leitao','leitao01@baidu.com','12345'),"
    + "(5,'gaoyanan01','gaoyanan01@baidu.com','12345'),"
    + "(6,'wangping','wangping06@baidu.com','12345'),"
    + "(7,'zhangtao','zhangtao09@baidu.com','12345'),"
    + "(8,'wangping','wangping06@baidu.com','12345'),"
    + "(9,'changhong','changhong@baidu.com','12345'),"
    + "(10,'lichun','lichun03@baidu.com','12345');";


}