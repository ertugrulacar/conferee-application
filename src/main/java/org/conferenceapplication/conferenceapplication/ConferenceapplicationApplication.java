package org.conferenceapplication.conferenceapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ConferenceapplicationApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(ConferenceapplicationApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConferenceapplicationApplication.class, args);
	}

}
