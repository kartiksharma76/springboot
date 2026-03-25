package com.demo.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;

import com.demo.bean.Dog;
import com.demo.bean.Rat;
@Configuration
public class AppConfig {
	@Value("${dog.name}")
private String name;
	@Value("${dog.age}")
	private String age;
	@Bean
	public Rat getRatBean() {
		return new Rat();
	}

	@Bean(name = "MyBean")
//	@Scope("prototype")
	public Dog getDogBean() {
		System.out.println(name);
		System.out.println(age);
		return new Dog(name,Integer.parseInt(age));

	}
	@Bean
	public Properties getDbInfoBean() throws IOException{
		Properties properties=new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("configProperties/dbInfo.properties"));
		return properties;
	}
}
