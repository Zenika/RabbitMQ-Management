package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.User;
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
public abstract class UserServiceTest extends ServiceTest {
	private UserService userService;

	private User dummyUser;

	@Before
	public void setUpDummyUser() {
		dummyUser = new User();
		dummyUser.setUsername("dummyUser");
		dummyUser.setPassword("dummyPassword");
		dummyUser.setAdmin(false);
	}

	/**
	 * Special tear down because the dummyUser might not be deleted each time
	 *
	 * @throws Exception
	 */
	@After
	public void tearDownDummyUser() throws Exception {
		try {
			userService.deleteUser(dummyUser.getUsername());
		}
		catch (Exception ignore) {
			//If user doesn't exist, nothing happens, it's okay
		}
	}

	@Test
	public void testGetUsers() throws Exception {
		List<User> users = userService.getUsers();
		assertTrue(users.contains(getCurrentUser()));
		assertFalse(users.contains(dummyUser));
	}

	@Test
	public void testGetUser() throws Exception {
		User user = userService.getUser(getCurrentUser().getUsername());
		assertEquals(getCurrentUser(), user);
	}

	@Test
	public void testPutUser() throws Exception {
		List<User> users = userService.getUsers();
		assertFalse(users.contains(dummyUser));

		userService.putUser(dummyUser);

		users = userService.getUsers();
		assertTrue(users.contains(dummyUser));
	}

	@Test
	public void testDeleteUser() throws Exception {
		userService.putUser(dummyUser);

		List<User> users = userService.getUsers();
		assertTrue(users.contains(dummyUser));

		userService.deleteUser(dummyUser.getUsername());

		users = userService.getUsers();
		assertFalse(users.contains(dummyUser));
	}

	@Test
	public void testGetPermissions() throws Exception {
		Permission dummyPermission = new Permission();
		dummyPermission.setUser(dummyUser.getUsername());
		dummyPermission.setConfigure("configurepath.*");
		dummyPermission.setWrite("writepath.*");
		dummyPermission.setRead("readpath.*");
		dummyPermission.setvHost(getvHost().getName());

		userService.putUser(dummyUser);
		List<Permission> permissions = userService.getPermissions(
				dummyUser.getUsername());
		assertNotNull(permissions);
		assertTrue(permissions.isEmpty());

		getPermissionService().putPermission(dummyPermission);

		permissions = userService.getPermissions(dummyUser.getUsername());
		assertNotNull(permissions);
		assertFalse(permissions.isEmpty());
		assertEquals(dummyPermission, permissions.get(0));
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
