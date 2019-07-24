package org.einnovator.devops.client.config;


import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.manager.ProjectManager;
import org.einnovator.devops.client.manager.ProjectManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;


@Configuration
@EnableConfigurationProperties(value=DevopsClientConfiguration.class)
public class DevopsClientConfig {


	@Autowired
	private DevopsClientConfiguration config;
	
	@Autowired
	private OAuth2ClientContext oauth2ClientContext;

	@Autowired
	private OAuth2ProtectedResourceDetails oauth2ResourceDetails;

	public ClientHttpRequestFactory clientHttpRequestFactory() {
		ConnectionConfiguration connConfig = config.getConnection();
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		
		if	(connConfig.getTimeout() != null) {
			clientHttpRequestFactory.setConnectTimeout(connConfig.getTimeout());
		}
		if	(connConfig.getRequestTimeout() != null) {
			clientHttpRequestFactory.setConnectionRequestTimeout(connConfig.getRequestTimeout());
		}
		if	(connConfig.getReadTimeout() != null) {
			clientHttpRequestFactory.setReadTimeout(connConfig.getReadTimeout());
		}
		return clientHttpRequestFactory;
	}
	
	@Bean
	public OAuth2RestTemplate metaRestTemplate() {
		OAuth2RestTemplate template;
		template = new OAuth2RestTemplate(oauth2ResourceDetails, oauth2ClientContext);			
		template.setRequestFactory(clientHttpRequestFactory());
		return template;
	}
	
	@Bean
	public DevopsClient channelClient() {
		return new DevopsClient(config);
	}

	@Bean
	public ProjectManager channelManager(CacheManager cacheManager) {
		return new ProjectManagerImpl(cacheManager);
	}


}
