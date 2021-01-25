package org.einnovator.devops.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.UUID;

import org.einnovator.devops.client.config.DevopsClientConfig;
import org.einnovator.devops.client.config.DevopsClientConfiguration;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.sso.client.SsoTestHelper;
import org.einnovator.util.PageUtil;
import org.einnovator.util.UriUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { DevopsClientConfig.class, DevopsClientTests.TestConfig.class }, webEnvironment = WebEnvironment.NONE)
@TestPropertySource(properties = { "devops.server=http://localhost:2501", "sso.server=http://localhost:2000",
		"spring.cache.ehcache.config:ehcache-devops-starter.xml" })
public class DevopsClientTests extends SsoTestHelper {

	public static final String TEST_USER = "jsimao71@gmail.com";
	public static final String TEST_USER2 = "tdd@einnovator.org";
	public static final String TEST_USER3 = "info@einnovator.org";
	public static final String TEST_PASSWORD = "Einnovator123!!";
	
	
	public static final String CLIENT_ID = "application";
	public static final String CLIENT_SECRET = "application$123";

	private static final String TEST_PROJECT = "TDD";
	
	@Autowired
	private DevopsClientConfiguration config;

	@Autowired
	private DevopsClient client;

	@Configuration
	static class TestConfig extends SsoTestHelper.TestConfig {

		public TestConfig(ApplicationContext context) {
			super(TEST_USER, TEST_PASSWORD, CLIENT_ID, CLIENT_SECRET, context);
		}
		
	}
	
	@Test
	public void listSpacesTest() {
		Page<Space> spaces = client.listSpaces(null, null);
		assertNotNull(spaces);
		assertNotNull(spaces.getContent());
		assertFalse(spaces.getNumberOfElements()==0);
		assertFalse(spaces.getContent().isEmpty());
		for (Space space: spaces) {
			System.out.println(space);			
		}
	}

	@Test
	public void listSpacesWithFilterTest() {
		String q = "E";
		SpaceFilter filter = new SpaceFilter().withQ("q");
		Page<Space> spaces = client.listSpaces(filter, null);
		assertNotNull(spaces);
		assertNotNull(spaces.getContent());
		assertFalse(spaces.getNumberOfElements()==0);
		assertFalse(spaces.getContent().isEmpty());
		for (Space space : spaces) {
			assertTrue(space.getName().contains(q));
		}
		
		q = "NOTFOUND-" + UUID.randomUUID();
		filter.setQ(q);
		spaces = client.listSpaces(filter, null);
		assertNotNull(spaces);
		assertNotNull(spaces.getContent());
		assertTrue(spaces.getNumberOfElements()==0);
		assertTrue(spaces.getContent().isEmpty());
	}

	@Test
	public void getExistingSpaceTest() {
		Space space = getOrCreateSpace(TEST_PROJECT);
		assertNotNull(space);
		assertEquals(TEST_PROJECT, space.getName());
	}

	public Space getOrCreateSpace(String name) {
		try {
			Space space = client.getSpace(name, null);		
			return space;
		} catch (RuntimeException e) {
		}
		SpaceFilter filter = new SpaceFilter();
		filter.setQ(name);
		Page<Space> page = client.listSpaces(filter, null);
		assertNotNull(page);
		assertNotNull(page.getContent());
		if (!page.getContent().isEmpty()) {
			return page.getContent().get(0);
		}
		Space space = (Space) new Space().withName(name);
		URI uri = client.createSpace(space, null);
		assertNotNull(uri);
		String id = UriUtils.extractId(uri);
		Space space2 = client.getSpace(id, null);
		return space2;
	}

	
	@Test
	public void createSpaceTest() {
		Space space = (Space) new Space().withName("test-" + UUID.randomUUID());
		URI uri = client.createSpace(space, null);
		String id = UriUtils.extractId(uri);
		Space space2 = client.getSpace(id, null);
		assertNotNull(space2);
		assertEquals(space.getName(), space2.getName());
	}
	
	@Test
	public void listDeploymentsTest() {
		Page<Space> spaces = client.listSpaces(null, null);
		assertNotNull(spaces);
		assertNotNull(spaces.getContent());
		assertFalse(spaces.getNumberOfElements()==0);
		assertFalse(spaces.getContent().isEmpty());
		for (Space space: spaces) {
			Page<Deployment> deploys = client.listDeployments(space.getUuid(), null, null);
			System.out.println(space.getName() + " " + PageUtil.toString(deploys));			
		}
	}


}