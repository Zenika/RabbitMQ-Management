package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.*;

import com.zenika.rabbitmq.management.beans.Permission;

/**
 * Permission management
 */
@Path("permissions")
public interface PermissionServiceRemote {

	/**
	 * Lists permissions for all users in all virtual hosts
	 *
	 * @return The permissions for all users in all virtual hosts
	 */
	@GET
	List<Permission> getPermissions();

	/**
	 * Get user permissions in a specific virtual host
	 *
	 * @param vHost The name of the virtual host
	 * @param user The name of the user for which to list the permissions
	 * @return The permissions on a specific vhost.
	 */
	@GET
	@Path("{vhost}/{user}")
	Permission getPermission(@PathParam("vhost") String vHost,
			@PathParam("user") String user);

	/**
	 * Sets user permissions
	 *
	 * @param vHost The name of the virtual host to which to grant the user access
	 * @param user The name of the user to grant access to the specified virtual
	 * host
	 * @param permission
	 */
	@PUT
	@Consumes("application/json")
	@Path("{vhost}/{user}")
	void putPermission(@PathParam("vhost") String vHost,
			@PathParam("user") String user, Permission permission);

	/**
	 * Remove user access on a specific virtual host
	 *
	 * @param vHost The name of the virtual host to which to deny the user access
	 * @param user The name of the user to deny access to the specified virtual
	 * host
	 */
	@DELETE
	@Path("{vhost}/{user}")
	void deletePermission(@PathParam("vhost") String vHost,
			@PathParam("user") String user);
}
