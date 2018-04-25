package com.ecommerce.sw2;

//import com.querydsl.codegen.GenericExporter;
//import com.querydsl.codegen.Keywords;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.*;
import java.io.File;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.bind.annotation.RequestMapping;

//import javax.persistence.Entity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Sw2Application {
	public static void main(String[] args) {
		SpringApplication.run(Sw2Application.class, args);
//		GenericExporter exporter = new GenericExporter();
//		exporter.setKeywords(Keywords.JPA);
//		exporter.setEntityAnnotation(Entity.class);
//		exporter.setEmbeddableAnnotation(Embeddable.class);
//		exporter.setEmbeddedAnnotation(Embedded.class);
//		exporter.setSupertypeAnnotation(MappedSuperclass.class);
//		exporter.setSkipAnnotation(Transient.class);
//		exporter.setTargetFolder(new File("target/generated-sources/java"));
//		exporter.export(Sw2Application.class.getPackage());
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
}