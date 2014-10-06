package com.bohdamyr.store.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * Application context configuration
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.bohdamyr.store." }, excludeFilters = {
		@ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
		@ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION) })
@EnableAspectJAutoProxy
@Import({ JpaConfig.class, WebSecurityConfig.class })
public class AppConfig {
}
