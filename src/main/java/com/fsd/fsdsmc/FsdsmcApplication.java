package com.fsd.sbauser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = "com.fsd.sbauser.service.*")
//@EnableJpaRepositories(basePackages = "com.fsd.sbauser.repository.*") 
//@EntityScan("com.fsd.sbauser.entity.*")
@SpringBootApplication
public class SbauserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbauserApplication.class, args);
	}

}
