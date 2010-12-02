package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.*;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.VHost;

@Path("vhosts")
public interface VHostServiceRemote {
	/**
	 * Lists virtual hosts
	 *
	 * @return the complete virtual hosts list
	 */
	@GET
	List<VHost> getVHosts();

	/**
	 * Retrieve a specific virtual host
	 *
	 * @param name The name of the virtual host to retrieve
	 * @return the required virtual host
	 */
	@GET
	@Path("{name}")
	VHost getVHost(@PathParam("name") String name);

	/**
	 * Create/update a virtual host
	 *
	 * @param name The name of the virtual host entry to create/update
	 * @param vHost Other parameters of the virtual host
	 */
	@PUT
	@Consumes("application/json")
	@Path("{name}")
	void putVHost(@PathParam("name") String name, VHost vHost);

	/**
	 * Delete a virtual host
	 * <p/>
	 * Deleting a virtual host deletes all its exchanges, queues, user mappings and
	 * associated permissions.
	 *
	 * @param name The name of the virtual host entry to delete
	 */
	@DELETE
	@Path("{name}")
	void deleteVHost(@PathParam("name") String name);

	@GET
	@Path("{name}/permissions")
	List<Permission> getPermissions(@PathParam("name") String name);
}
