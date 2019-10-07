package com.nav.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories("com.nav.repository")
@ComponentScan(value = { "com.nav.controller","com.nav.model","com.nav.configuration" })
@EntityScan("com.nav.model")
public class BootJspApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootJspApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BootJspApplication.class, args) ;
	}

	@Bean
	public FilterRegistrationBean<CORSFilter> filterRegistrationBean() {
		FilterRegistrationBean<CORSFilter> registrationBean = new FilterRegistrationBean();
		CORSFilter customURLFilter = new CORSFilter();
		registrationBean.setFilter(customURLFilter);
		registrationBean.addUrlPatterns("/*");
		// registrationBean.setOrder(2); //set precedence
		return registrationBean;
	}

}
