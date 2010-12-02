package com.zenika.rabbitmq.management.services;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.User;
import com.zenika.rabbitmq.management.beans.VHost;
import org.junit.After;
import org.junit.Before;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

public abstract class ServiceTest {
	private VHostService vHostService;

	private PermissionService permissionService;

	private VHost vHost;

	private User currentUser;

	private ConnectionFactory connectionFactory;

	@Before
	public void setUp() throws Exception {
		vHostService.putVHost(vHost);

		Permission permission = new Permission();
		permission.setUser(currentUser.getUsername());
		permission.setvHost(vHost.getName());
		permission.setConfigure(".*");
		permission.setRead(".*");
		permission.setWrite(".*");

		permissionService.putPermission(permission);
	}

	@After
	public void tearDown() throws Exception {
		vHostService.deleteVHost(vHost.getName());
	}

	public VHostService getvHostService() {
		return vHostService;
	}

	public void setvHostService(VHostService vHostService) {
		this.vHostService = vHostService;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public VHost getvHost() {
		return vHost;
	}

	public void setvHost(VHost vHost) {
		this.vHost = vHost;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
}
