package com.example.assurance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssuranceApplication {
	public static final Logger log = LoggerFactory.getLogger(AssuranceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AssuranceApplication.class, args);
		log.info("""

				================================================================================================
				                                   ACTION' ELLES ASSURANCE STARTED...
				================================================================================================"""
		);
	}

}
