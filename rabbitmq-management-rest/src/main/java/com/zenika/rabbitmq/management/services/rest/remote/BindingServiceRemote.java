package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.*;

import com.zenika.rabbitmq.management.beans.Binding;

@Path("bindings")
public interface BindingServiceRemote {
	@GET
	List<Binding> getBindings();

	@GET
	@Path("{vhost}")
	List<Binding> getBindings(@PathParam("vhost") String vHost);

	@GET
	@Path("{vhost}/e/{source}/{destinationType:[eq]}/{destination}")
	List<Binding> getBindings(@PathParam("vhost") String vHost,
			@PathParam("source") String source,
			@PathParam("destinationType") char destinationType,
			@PathParam("destination") String destination);

	@POST
	@Consumes("application/json")
	@Path("{vhost}/e/{source}/{destinationType:[eq]}/{destination}")
	void postBinding(@PathParam("vhost") String vHost,
			@PathParam("source") String source,
			@PathParam("destinationType") char destinationType,
			@PathParam("destination") String queue, Binding binding);

	@GET
	@Path("{vhost}/e/{source}/{destinationType:[eq]}/{destination}/{props}")
	Binding getBinding(@PathParam("vhost") String vHost,
			@PathParam("source") String source,
			@PathParam("destinationType") char destinationType,
			@PathParam("destination") String destination,
			@PathParam("props") String props);

	@PUT
	@Consumes("application/json")
	@Path("{vhost}/e/{source}/{destinationType:[eq]}/{destination}/{props}")
	void putBinding(@PathParam("vhost") String vHost,
			@PathParam("source") String source,
			@PathParam("destinationType") char destinationType,
			@PathParam("destination") String destination,
			@PathParam("props") String props, Binding binding);

	@DELETE
	@Path("{vhost}/e/{source}/{destinationType:[eq]}/{destination}/{props}")
	void deleteBinding(@PathParam("vhost") String vHost,
			@PathParam("source") String source,
			@PathParam("destinationType") char destinationType,
			@PathParam("destination") String destination,
			@PathParam("props") String props);
}
