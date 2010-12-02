package com.zenika.rabbitmq.management.services;

import java.util.Iterator;
import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public abstract class AbstractPermissionService implements PermissionService {
	public Permission getPermission(VHost vHost, String user) {
		return getPermission(vHost.getName(), user);
	}

	public List<Permission> getPermissions(String vHostName) {
		List<Permission> permissions = getPermissions();
		for (Iterator<Permission> permissionIterator = permissions.iterator(); permissionIterator.hasNext();) {
			Permission permission = permissionIterator.next();
			if (!vHostName.equals(permission.getvHost())) {
				permissionIterator.remove();
			}
		}

		return permissions;
	}

	public List<Permission> getPermissions(VHost vHost) {
		return getPermissions(vHost.getName());
	}

	public Permission getPermission(String vHostName, String userName) {
		for (Permission permission : getPermissions()) {
			if (vHostName.equals(permission.getvHost()) && userName.equals(
					permission.getUser())) {
				return permission;
			}
		}
		return null;
	}
}
