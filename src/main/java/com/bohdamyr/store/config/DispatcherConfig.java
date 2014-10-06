package com.bohdamyr.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * Dispatcher-servlet configurations
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "com.bohdamyr.store.controller" })
public class DispatcherConfig extends WebMvcConfigurerAdapter {

	/**
	 * Apache Tiles configurations
	 * 
	 * @return
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer
				.setDefinitions(new String[] { "/WEB-INF/defs/general.xml" });
		tilesConfigurer
				.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
		return tilesConfigurer;
	}

	/**
	 * View resolver based on TilesView
	 * 
	 * @return UrlBasedViewResolver
	 */
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		viewResolver.setOrder(0);
		return viewResolver;
	}

	/**
	 * Stores registrations of resource handlers for servingg static resources
	 * such as images, css files, etc.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

}
