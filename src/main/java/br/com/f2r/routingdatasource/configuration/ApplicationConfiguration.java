package br.com.f2r.routingdatasource.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement(proxyTargetClass=true)
@EnableWebMvc
@ComponentScan(basePackages={"br.com.f2r"})
@PropertySource(value={"classpath:application.properties"})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{
	
	@Autowired
	private Environment enviroiment;
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	 }
	/*
	@Bean
	public DriverManagerDataSource myDataSource(){
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(enviroiment.getRequiredProperty("jdbc.driverClassName"));
		datasource.setUrl(enviroiment.getRequiredProperty("jdbc.url.0"));
		datasource.setUsername(enviroiment.getRequiredProperty("jdbc.username"));
		datasource.setPassword(enviroiment.getRequiredProperty("jdbc.password"));
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("hibernate.dialect", enviroiment.getRequiredProperty("hibernate.dialect"));
		connectionProperties.setProperty("hibernate.show_sql", enviroiment.getRequiredProperty("hibernate.show_sql"));
		connectionProperties.setProperty("hibernate.format_sql", enviroiment.getRequiredProperty("hibernate.format_sql"));
		datasource.setConnectionProperties(connectionProperties);
		return datasource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(myDataSource());
		entityManagerFactory.setPersistenceXmlLocation("classpath:persistence.xml");
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return entityManagerFactory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	*/
}

