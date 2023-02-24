package space.bumtiger.ssnAttr.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import space.bumtiger.ssnAttr.demo.domain.TodoList;

@Configuration
public class ProjectConfig {

	// @formatter:off
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, 
				 proxyMode = ScopedProxyMode.TARGET_CLASS)
	TodoList todos() {
		return new TodoList();
	}
	// @formatter:on

}
