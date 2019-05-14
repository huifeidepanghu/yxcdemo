package com.sgcc.epri.dataexchangeplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sgcc.epri.dataexchangeplatform.Mapper")
public class DataExchangePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataExchangePlatformApplication.class, args);
	}

}
