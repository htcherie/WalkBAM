package com.walkBAM;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.walkBAM.dao")
@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan
@SuppressWarnings("SpringJavaAutowiringInspection")
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}
//	/**
//	 * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
//	 */
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(DemoApplication.class);
//	}
}
