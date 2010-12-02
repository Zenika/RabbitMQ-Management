package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.VHost;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Colin Hebert
 */
public abstract class VHostServiceTest extends ServiceTest {
	private VHost dummyVHost;

	@Before
	public void setUpVHost() {
		dummyVHost = new VHost();
		dummyVHost.setName("/dummyVHost");
	}

	/**
	 * Special tearDown because the dummyVHost might not be deleted each time
	 *
	 * @throws Exception
	 */
	@After
	public void tearDownVHost() throws Exception {
		try {
			getvHostService().deleteVHost(dummyVHost.getName());
		}
		catch (Exception ignore) {
			//If vHost doesn't exist nothing happens, it's okay
		}
	}

	@Test
	public void testGetVHosts() throws Exception {
		List<VHost> vHosts = getvHostService().getVHosts();
		assertTrue(vHosts.contains(getvHost()));
		assertFalse(vHosts.contains(dummyVHost));
	}

	@Test
	public void testGetVHost() throws Exception {
		VHost vHost = getvHostService().getVHost(getvHost().getName());
		assertEquals(getvHost(), vHost);
	}

	@Test
	public void testPutVHost() throws Exception {
		List<VHost> vHosts = getvHostService().getVHosts();
		assertFalse(vHosts.contains(dummyVHost));

		getvHostService().putVHost(dummyVHost);

		vHosts = getvHostService().getVHosts();
		assertTrue(vHosts.contains(dummyVHost));

	}

	@Test
	public void testDeleteVHost() throws Exception {
		getvHostService().putVHost(dummyVHost);

		List<VHost> vHosts = getvHostService().getVHosts();
		assertTrue(vHosts.contains(dummyVHost));

		getvHostService().deleteVHost(dummyVHost);

		vHosts = getvHostService().getVHosts();
		assertFalse(vHosts.contains(dummyVHost));
	}

	@Test
	public void testGetPermissions() throws Exception {
		Permission dummyPermission = new Permission();
		dummyPermission.setUser(getCurrentUser().getUsername());
		dummyPermission.setConfigure("configurepath.*");
		dummyPermission.setWrite("writepath.*");
		dummyPermission.setRead("readpath.*");
		dummyPermission.setScope(Permission.Scope.client);
		dummyPermission.setvHost(dummyVHost.getName());

		getvHostService().putVHost(dummyVHost);
		List<Permission> permissions = getvHostService().getPermissions(
				dummyVHost);
		assertNotNull(permissions);
		assertTrue(permissions.isEmpty());

		getPermissionService().putPermission(dummyPermission);

		permissions = getvHostService().getPermissions(dummyVHost);
		assertNotNull(permissions);
		assertFalse(permissions.isEmpty());
		assertEquals(dummyPermission, permissions.get(0));
	}
}
