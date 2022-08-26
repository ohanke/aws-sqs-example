package com.oscarhanke.awssqsexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(
		exclude = {
				ContextStackAutoConfiguration.class,
				ContextInstanceDataAutoConfiguration.class,
				ContextRegionProviderAutoConfiguration.class
		})
public class AwsSqsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsExampleApplication.class, args);
	}

}
