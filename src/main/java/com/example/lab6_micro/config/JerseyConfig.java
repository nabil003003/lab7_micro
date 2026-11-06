package com.example.lab6_micro.config;

import com.example.lab6_micro.api.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig {
	@Bean
	public ResourceConfig resourceConfig() {
		ResourceConfig config = new ResourceConfig();
		config.register(CompteRestJaxRSAPI.class);
		return config;
	}
}
