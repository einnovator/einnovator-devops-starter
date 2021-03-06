package org.einnovator.devops.client.config;


import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.manager.VcsManager;
import org.einnovator.devops.client.manager.VcsManagerImpl;
import org.einnovator.devops.client.manager.DeploymentManager;
import org.einnovator.devops.client.manager.DeploymentManagerImpl;
import org.einnovator.devops.client.manager.LicenseManager;
import org.einnovator.devops.client.manager.LicenseManagerImpl;
import org.einnovator.devops.client.manager.SpaceManager;
import org.einnovator.devops.client.manager.SpaceManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
	
	@Autowired(required=false)
	private OAuth2ClientContext oauth2ClientContext;

	@Autowired(required=false)
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
	@ConditionalOnMissingBean(name = "devopsRestTemplate")
	@ConditionalOnProperty(matchIfMissing = true, name = "devops.client.session", havingValue = "true")
	public OAuth2RestTemplate devopsRestTemplate() {
		OAuth2RestTemplate template;
		template = new OAuth2RestTemplate(oauth2ResourceDetails, oauth2ClientContext);			
		template.setRequestFactory(clientHttpRequestFactory());
		return template;
	}
	
	@Bean
	public DevopsClient devopsClient() {
		return new DevopsClient(config);
	}

	@Bean
	public SpaceManager devopsSpaceManager(CacheManager cacheManager) {
		return new SpaceManagerImpl(cacheManager);
	}

	@Bean
	public DeploymentManager devopsDeploymentManager(CacheManager cacheManager) {
		return new DeploymentManagerImpl(cacheManager);
	}
	
	@Bean
	public VcsManager devopsVcsManager(CacheManager cacheManager) {
		return new VcsManagerImpl(cacheManager);
	}

	@Bean
	public LicenseManager devopsLicenseManager(CacheManager cacheManager) {
		return new LicenseManagerImpl(cacheManager);
	}
}
