package com.ztc.springB;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//service无法注入dao添加以下注解，通过@MapperScan注解进行dao文件的扫描或者mapper接口上加@Mapper注解
//@MapperScan("com.ztc.springB.dao")
public class SpringBApplication {
//spring boot程序只加载Application.java所在包及其子包下的内容。
	public static void main(String[] args) {
		SpringApplication.run(SpringBApplication.class, args);
	}
}
