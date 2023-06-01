package com.codeking.serverMessage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.codeking.serverMessage.mapper")
@SpringBootApplication
public class ServerMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerMessageApplication.class, args);
	}

}
