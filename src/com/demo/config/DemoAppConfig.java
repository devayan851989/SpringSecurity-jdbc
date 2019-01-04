package com.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.codehaus.plexus.component.annotations.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DriverManagerDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demo")
@PropertySource("file:///C:/Learning/SPRING/SpringSecurityJDBC/src/main/resources/persistence-mysql.properties")
public class DemoAppConfig {
	
	@Value( "${jdbc.driver}" )
	private String jdbcdriver;
	
	@Value( "${jdbc.url}" )
	private String jdbcUrl;
	
	@Value( "${jdbc.user}" )
	private String jdbcusername;
	
	@Value( "${jdbc.password}" )
	private String jdbcpassword;

	// set up variable to hold the properties

	@Autowired
	private Environment env;

	// set up a logger for diagnostics

	private Logger logger = Logger.getLogger(getClass().getName());
	
	
/*
	// define a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// set the jdbc driver class
		try {
			
		
			//securityDataSource.setDriverClass(env.getProperty("jdbc:driver"));
			securityDataSource.setDriverClass(jdbcdriver);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		// log the connection props
		logger.info(">>jdbc url" + env.getProperty("jdbc:url"));
		logger.info(">>jdbc user" + env.getProperty("jdbc:user"));
		logger.info(">>jdbc password" + env.getProperty("jdbc:password"));
		
		logger.info(">>jdbc url1" + jdbcdriver);
		logger.info(">>jdbc url1" + jdbcUrl);
		logger.info(">>jdbc user" + jdbcusername);
		logger.info(">>jdbc password" + jdbcpassword);
		
		

		// set database connection props

		securityDataSource.setJdbcUrl(env.getProperty("jdbc:url"));
		securityDataSource.setJdbcUrl(env.getProperty("jdbc:username"));
		securityDataSource.setJdbcUrl(env.getProperty("jdbc:password"));
		
		securityDataSource.setJdbcUrl(env.getProperty(jdbcUrl));
		securityDataSource.setUser(env.getProperty(jdbcusername));
		securityDataSource.setPassword(env.getProperty(jdbcpassword));

		// set connection pool props

		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;
		
		@Bean
		public DataSource securityDataSource() {
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
	    System.out.println("JDBC Driver Found");
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	       driverManagerDataSource.setDriverClass("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springsecure");
	    driverManagerDataSource.setUser("root");
	    driverManagerDataSource.setPassword("mysql");
	    return driverManagerDataSource;
	*/
		
		@Bean
		public DataSource securityDataSource() {
		System.out.println("-------- Oracle JDBC Connection Testing ------------");
	    System.out.println("JDBC Driver Found");
	    logger.info(">>jdbc url1" + jdbcdriver);
		logger.info(">>jdbc url1" + jdbcUrl);
		logger.info(">>jdbc user" + jdbcusername);
		logger.info(">>jdbc password" + jdbcpassword);
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	       driverManagerDataSource.setDriverClass(jdbcdriver);
	    driverManagerDataSource.setJdbcUrl(jdbcUrl);
	    driverManagerDataSource.setUser(jdbcusername);
	    driverManagerDataSource.setPassword(jdbcpassword);
	    return driverManagerDataSource;
	    
	}

	// need a helper method
	// read environment property and convert into int

	private int getIntProperty(String propName) {

		String propVal = env.getProperty(propName);

		// now convert to int

		int intPropVal = Integer.parseInt(propVal);

		return intPropVal;
	}

	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}

}
