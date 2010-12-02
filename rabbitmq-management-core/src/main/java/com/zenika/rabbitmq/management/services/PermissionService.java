package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public interface PermissionService {

	/**
	 * Lists permissions for all users in all virtual hosts
	 *
	 * @return The permissions for all users in all virtual hosts
	 */
	List<Permission> getPermissions();

	List<Permission> getPermissions(String vHostName);

	List<Permission> getPermissions(VHost vHost);

	/**
	 * Get user permissions in a specific virtual host
	 *
	 * @param vHost The name of the virtual host
	 * @param user The name of the user for which to list the permissions
	 * @return The permissions on a specific vhost.
	 */
	Permission getPermission(String vHost, String user);

	Permission getPermission(VHost vHost, String user);

	/**
	 * Sets user permissions
	 *
	 * @param permission
	 */
	void putPermission(Permission permission);

	/**
	 * Remove user access on a specific virtual host
	 *
	 * @param permission
	 */
	void deletePermission(Permission permission);
}
