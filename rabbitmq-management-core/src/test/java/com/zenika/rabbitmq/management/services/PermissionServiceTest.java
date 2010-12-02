package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Colin Hebert
 */
public abstract class PermissionServiceTest extends ServiceTest {
	private Permission dummyPermission;

	@Before
	public void setUpDummyPermissions() throws Exception {
		dummyPermission = new Permission();
		dummyPermission.setUser(getCurrentUser().getUsername());
		dummyPermission.setConfigure("configurepath.*");
		dummyPermission.setWrite("writepath.*");
		dummyPermission.setRead("readpath.*");
		dummyPermission.setvHost(getvHost().getName());
	}

	@Test
	public void testGetPermissions() throws Exception {
		List<Permission> permissionList = getPermissionService().getPermissions();
		assertNotNull(permissionList);
		assertFalse(permissionList.contains(dummyPermission));
	}

	@Test
	public void testGetPermission() throws Exception {

		getPermissionService().putPermission(dummyPermission);

		Permission permission = getPermissionService().getPermission(
				dummyPermission.getvHost(), dummyPermission.getUser());

		assertNotNull(permission);
		assertEquals(dummyPermission, permission);
	}

	@Test
	public void testPutPermission() throws Exception {
		List<Permission> permissionList = getPermissionService().getPermissions();
		assertFalse(permissionList.contains(dummyPermission));

		getPermissionService().putPermission(dummyPermission);

		permissionList = getPermissionService().getPermissions();
		assertTrue(permissionList.contains(dummyPermission));
	}

	@Test
	public void testDeletePermission() throws Exception {
		getPermissionService().putPermission(dummyPermission);

		List<Permission> permissionList = getPermissionService().getPermissions();
		assertTrue(permissionList.contains(dummyPermission));

		getPermissionService().deletePermission(dummyPermission);

		permissionList = getPermissionService().getPermissions();
		assertFalse(permissionList.contains(dummyPermission));

	}
}
