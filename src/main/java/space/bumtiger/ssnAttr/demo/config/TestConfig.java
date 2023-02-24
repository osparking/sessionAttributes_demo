package space.bumtiger.ssnAttr.demo.config;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
public class TestConfig {

	@Bean
	CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.addScope("session", new SimpleThreadScope());
		return configurer;
	}
}
