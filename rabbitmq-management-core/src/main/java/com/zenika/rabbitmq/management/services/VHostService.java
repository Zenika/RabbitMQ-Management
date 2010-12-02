package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public interface VHostService {
	/**
	 * Lists virtual hosts
	 *
	 * @return the complete virtual hosts list
	 */
	List<VHost> getVHosts();

	/**
	 * Retrieve a specific virtual host
	 *
	 * @param vHostName The name of the virtual host to retrieve
	 * @return the required virtual host
	 */
	VHost getVHost(String vHostName);

	/**
	 * Create/update a virtual host
	 *
	 * @param vHost VHost to create/update
	 */
	void putVHost(VHost vHost);

	/**
	 * Delete a virtual host
	 * <p/>
	 * Deleting a virtual host deletes all its exchanges, queues, user mappings and
	 * associated permissions.
	 *
	 * @param vHostName The name of the virtual host entry to delete
	 */
	void deleteVHost(String vHostName);

	void deleteVHost(VHost vHost);

	List<Permission> getPermissions(String vHostName);

	List<Permission> getPermissions(VHost vHost);

}
