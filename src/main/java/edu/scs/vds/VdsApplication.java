package edu.scs.vds;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan("edu.scs.vds")
//@EnableAutoConfiguration
@EnableSwagger2
public class VdsApplication {

//
//	@Value("${spring.datasource.driverClassName}")
//	private String databaseDriverClassName;
//
//	@Value("${spring.datasource.url}")
//	private String datasourceUrl;
//
//	@Value("${spring.datasource.username}")
//	private String databaseUsername;
//
//	@Value("${spring.datasource.password}")
//	private String databasePassword;
//
//
//	@Bean
//	public DataSource dataSource() {
//		DataSource dataSource = new DataSource();
//		dataSource.setDriverClassName(databaseDriverClassName);
//		dataSource.setUrl(datasourceUrl);
//		dataSource.setUsername(databaseUsername);
//		dataSource.setPassword(databasePassword);
//
//		return dataSource;
//	}

	public static void main(String[] args) {
		SpringApplication.run(VdsApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("edu.scs.vds.controller")).build();
	}



}
