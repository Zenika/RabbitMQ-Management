package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.*;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.User;

/**
 * User management
 */
@Path("users")
public interface UserServiceRemote {
	/**
	 * List all users available on the server
	 *
	 * @return the complete user list
	 */
	@GET
	List<User> getUsers();

	/**
	 * Retrieve a specific user of the server
	 *
	 * @param name The name of the user to retrieve
	 * @return the required user
	 */
	@GET
	@Path("{name}")
	User getUser(@PathParam("name") String name);

	/**
	 * Create/update a new user onto the broker
	 *
	 * @param name The name of the user to create/update
	 * @param user Other parameters of the user
	 */
	@PUT
	@Consumes("application/json")
	@Path("{name}")
	void putUser(@PathParam("name") String name, User user);

	/**
	 * Delete a user from the broker
	 *
	 * @param name The name of the user to delete
	 */
	@DELETE
	@Path("{name}")
	void deleteUser(@PathParam("name") String name);

	/**
	 * Lists user permissions
	 *
	 * @param user The name of the user for which to list the permissions
	 * @return
	 */
	@GET
	@Path("{user}/permissions")
	List<Permission> getPermissions(@PathParam("user") String user);
}
