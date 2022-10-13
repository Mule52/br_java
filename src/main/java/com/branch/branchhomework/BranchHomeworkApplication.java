package com.branch.branchhomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BranchHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BranchHomeworkApplication.class, args);
	}
}