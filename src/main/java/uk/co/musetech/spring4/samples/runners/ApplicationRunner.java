package uk.co.musetech.spring4.samples.runners;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Configuration
// load beans from xml file
@ImportResource("classpath:/spring4-samples-app.xml")
// load beans from another config class
@Import(WebSocketConfig.class)
@EnableAutoConfiguration
public class ApplicationRunner {

	private static Log logger = LogFactory.getLog(ApplicationRunner.class);

	public static void main(String[] args) throws Exception {
		//SpringApplication.run("classpath:/applicationContext.xml", args);
		SpringApplication.run(ApplicationRunner.class, args);
	}

	// creating new beans programmatically
	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {
			@Override
			public void contextInitialized(ServletContextEvent sce) {
				logger.info("ServletContext initialized");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				logger.info("ServletContext destroyed");
			}
		};
	}

}