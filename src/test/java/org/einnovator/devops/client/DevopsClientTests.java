package org.einnovator.devops.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.UUID;

import org.einnovator.devops.client.config.DevopsClientConfig;
import org.einnovator.devops.client.config.DevopsClientConfiguration;
import org.einnovator.devops.client.model.Project;
import org.einnovator.devops.client.model.ProjectBuilder;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.model.SpaceBuilder;
import org.einnovator.devops.client.modelx.ProjectFilter;
import org.einnovator.sso.client.SsoTestHelper;
import org.einnovator.util.UriUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DevopsClientConfig.class, DevopsClientTests.TestConfig.class }, webEnvironment = WebEnvironment.NONE)
@TestPropertySource(properties = { "devops.server=http://localhost:2501", "sso.server=http://localhost:2001",
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
	public void listProjectsTest() {
		Page<Project> spaces = client.listProjects(null, null, null);
		assertNotNull(spaces);
		assertNotNull(spaces.getContent());
		assertFalse(spaces.getNumberOfElements()==0);
		assertFalse(spaces.getContent().isEmpty());
		for (Project space: spaces) {
			System.out.println(space);			
		}
	}

	@Test
	public void listProjectsWithFilterTest() {
		String q = "E";
		ProjectFilter filter = new ProjectFilter();
		filter.setQ(q);
		Page<Project> spaces = client.listProjects(filter, null, null);
		assertNotNull(spaces);
		assertNotNull(spaces.getContent());
		assertFalse(spaces.getNumberOfElements()==0);
		assertFalse(spaces.getContent().isEmpty());
		for (Project space : spaces) {
			assertTrue(space.getName().contains(q));
		}
		
		q = "NOTFOUND-" + UUID.randomUUID();
		filter.setQ(q);
		spaces = client.listProjects(filter, null, null);
		assertNotNull(spaces);
		assertNotNull(spaces.getContent());
		assertTrue(spaces.getNumberOfElements()==0);
		assertTrue(spaces.getContent().isEmpty());
	}

	@Test
	public void getExistingProjectTest() {
		Project project = getOrCreateProject(TEST_PROJECT);
		assertNotNull(project);
		assertEquals(TEST_PROJECT, project.getName());
	}

	public Project getOrCreateProject(String name) {
		try {
			Project project = client.getProject(name, null);		
			return project;
		} catch (RuntimeException e) {
		}
		ProjectFilter filter = new ProjectFilter();
		filter.setQ(name);
		filter.setStrict(true);
		Page<Project> page = client.listProjects(filter, null, null);
		assertNotNull(page);
		assertNotNull(page.getContent());
		if (!page.getContent().isEmpty()) {
			return page.getContent().get(0);
		}
		Project project = new ProjectBuilder().withName(name).build();
		URI uri = client.createProject(project, null, null);
		assertNotNull(uri);
		String id = UriUtils.extractId(uri);
		Project project2 = client.getProject(id, null);
		return project2;
	}

	
	@Test
	public void createSpaceTest() {
		Project project = getOrCreateProject(TEST_PROJECT);
		Space space = new SpaceBuilder().withName("test-" + UUID.randomUUID()).build();
		URI uri = client.createSpace(project.getUuid(), space, null, null);
		String id = UriUtils.extractId(uri);
		Space space2 = client.getSpace(id, null, null);
		assertNotNull(space2);
		assertEquals(space.getName(), space2.getName());
	}


}