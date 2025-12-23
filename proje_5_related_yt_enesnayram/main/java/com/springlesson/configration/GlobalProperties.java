package com.springlesson.configration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/*@Component
@ConfigurationProperties()
@Data
public class GlobalProperties {
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
}
*/

@Component
@ConfigurationProperties(prefix = "app")
@Data
public class GlobalProperties {
	private List<Server> servers;
}