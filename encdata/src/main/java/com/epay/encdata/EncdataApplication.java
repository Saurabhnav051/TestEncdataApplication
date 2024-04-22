
package com.epay.encdata;

import javax.servlet.ServletContextListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;

/*@SpringBootApplication
@EnableWebMvc
public class EncdataApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		
		SpringApplication.run(EncdataApplication.class, args);
		
	}

}
*/

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//import com.sbi.epay.util.ContextListener;

//https://jenkov.com/tutorials/maven/publish-to-central-maven-repository.html  //maven publish step by step 
//https://pgpkeygen.com/   //pgp key generate
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) 
public class EncdataApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	
	/*
	 * @Bean public ServletListenerRegistrationBean<ServletContextListener>
	 * listenerRegistrationBean() {
	 * ServletListenerRegistrationBean<ServletContextListener> bean = new
	 * ServletListenerRegistrationBean<>(); bean.setListener(new ContextListener());
	 * return bean; }
	 */
	 

	
	
	/*
	 * @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	 
	 
	public void addViewControllers(ViewControllerRegistry registry) {
		// registry.addViewController("/home").setViewName("baedal-home");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/add").setViewName("add");
		
		registry.addViewController("/transaction6").setViewName("transaction6");

	}

	public static void main(String[] args) {

		/*
		 * System.setProperty("logPath", "logs/debug.log");
		 * System.setProperty("ERROR_LOG", "logs/error.log");
		 * System.setProperty("INFO_LOG", "logs/info.log");
		 */
		SpringApplication.run(EncdataApplication.class, args);
	}

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EncdataApplication.class);
	} 
}
