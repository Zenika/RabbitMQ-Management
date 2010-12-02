package com.zenika.rabbitmq.management.converter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.converter.toadmin.AdminConverter;
import com.zenika.rabbitmq.management.services.AbstractPermissionService;
import com.zenika.rabbitmq.management.services.PermissionService;
import org.springframework.amqp.rabbit.admin.RabbitBrokerOperations;

/**
 * @author Colin Hebert
 */
public class PermissionServiceAdmin extends AbstractPermissionService implements
		PermissionService {
	private final RabbitBrokerOperations rabbitBrokerOperations;

	public PermissionServiceAdmin(
			RabbitBrokerOperations rabbitBrokerOperations) {
		this.rabbitBrokerOperations = rabbitBrokerOperations;
	}

	public List<Permission> getPermissions() {
		List<Permission> permissions = new ArrayList<Permission>();
		for (String adminPermission : rabbitBrokerOperations.listPermissions()) {
			permissions.add(AdminConverter.convertPermission(adminPermission));
		}

		return permissions;
	}

	@Override
	public List<Permission> getPermissions(String vHostName) {
		List<Permission> permissions = new ArrayList<Permission>();
		for (String adminPermission : rabbitBrokerOperations.listPermissions(
				vHostName)) {
			permissions.add(AdminConverter.convertPermission(adminPermission));
		}

		return permissions;
	}

	@Override
	public Permission getPermission(String vHostName, String userName) {
		for (String adminPermission : rabbitBrokerOperations.listUserPermissions(
				userName)) {
			Permission permission = (AdminConverter.convertPermission(
					adminPermission));
			if (vHostName.equals(permission.getvHost()))
				return permission;
		}

		return null;
	}

	public void putPermission(Permission permission) {
		rabbitBrokerOperations.setPermissions(permission.getUser(),
				Pattern.compile(permission.getConfigure()),
				Pattern.compile(permission.getRead()),
				Pattern.compile(permission.getWrite()), permission.getvHost());
	}

	public void deletePermission(Permission permission) {
		rabbitBrokerOperations.clearPermissions(permission.getUser(),
				permission.getvHost());
	}
}
