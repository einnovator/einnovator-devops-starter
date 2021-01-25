package org.einnovator.devops.client.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.UUID;

import org.einnovator.devops.client.config.DevopsClientConfig;
import org.einnovator.devops.client.config.DevopsClientConfiguration;
import org.einnovator.devops.client.model.License;
import org.einnovator.devops.client.modelx.LicenseFilter;
import org.einnovator.sso.client.SsoTestHelper;
import org.einnovator.util.UriUtils;
import org.junit.jupiter.api.Disabled;
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
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { DevopsClientConfig.class, LicenseManagerTests.TestConfig.class }, webEnvironment = WebEnvironment.NONE)
@TestPropertySource(properties = { "devops.server=http://localhost:2501", "sso.server=http://localhost:2001",
		"spring.cache.ehcache.config:ehcache-devops-starter.xml" })
public class LicenseManagerTests extends SsoTestHelper {

	public static final String TEST_USER = "jsimao71@gmail.com";
	public static final String TEST_USER2 = "tdd@einnovator.org";
	public static final String TEST_USER3 = "info@einnovator.org";
	public static final String TEST_PASSWORD = "Einnovator123!!";
	
	
	public static final String CLIENT_ID = "application";
	public static final String CLIENT_SECRET = "application$123";

	private static final String TEST_SOLUTION = "TDD";
	
	@Autowired
	private DevopsClientConfiguration config;

	@Autowired
	private LicenseManager manager;

	@Configuration
	static class TestConfig extends SsoTestHelper.TestConfig {

		public TestConfig(ApplicationContext context) {
			super(TEST_USER, TEST_PASSWORD, CLIENT_ID, CLIENT_SECRET, context);
		}
		
	}
	
	@Test
	public void listLicensesTest() {
		Page<License> licenses = manager.listLicenses(null, null);
		assertNotNull(licenses);
		assertNotNull(licenses.getContent());
		assertFalse(licenses.getNumberOfElements()==0);
		assertFalse(licenses.getContent().isEmpty());
		for (License license: licenses) {
			System.out.println(license);			
		}
	}

	@Test
	public void listLicensesWithFilterTest() {
		String q = "e";
		LicenseFilter filter = new LicenseFilter().withQ(q);
		Page<License> licenses = manager.listLicenses(filter, null);
		assertNotNull(licenses);
		assertNotNull(licenses.getContent());
		assertFalse(licenses.getNumberOfElements()==0);
		assertFalse(licenses.getContent().isEmpty());
		for (License license : licenses) {
			assertTrue(license.getName().contains(q));
		}
		
		q = "NOTFOUND-" + UUID.randomUUID();
		filter.setQ(q);
		licenses = manager.listLicenses(filter, null);
		assertNotNull(licenses);
		assertNotNull(licenses.getContent());
		assertTrue(licenses.getNumberOfElements()==0);
		assertTrue(licenses.getContent().isEmpty());
	}

	@Test
	@Disabled
	public void getExistingLicenseTest() {
		License license = getOrCreateLicense(TEST_SOLUTION);
		assertNotNull(license);
		assertEquals(TEST_SOLUTION, license.getName());
	}

	public License getOrCreateLicense(String name) {
		try {
			License license = manager.getLicense(name, null);		
			return license;
		} catch (RuntimeException e) {
		}
		LicenseFilter filter = new LicenseFilter();
		filter.setQ(name);
		Page<License> page = manager.listLicenses(filter, null);
		assertNotNull(page);
		assertNotNull(page.getContent());
		if (!page.getContent().isEmpty()) {
			return page.getContent().get(0);
		}
		License license = (License) new License().withName(name);
		URI uri = manager.createLicense(license, null);
		assertNotNull(uri);
		String id = UriUtils.extractId(uri);
		License license2 = manager.getLicense(id, null);
		return license2;
	}

	
	@Test
	@Disabled
	public void createLicenseTest() {
		License license = (License) new License().withName("test-" + UUID.randomUUID());
		URI uri = manager.createLicense(license, null);
		String id = UriUtils.extractId(uri);
		License license2 = manager.getLicense(id, null);
		assertNotNull(license2);
		assertEquals(license.getName(), license2.getName());
	}


}