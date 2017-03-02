package com.simple.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.simple.model.User;

@Path("users")
public interface UserService {
	void registerUser(User user);

	@GET
	@Path("{id : \\d+}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	User getUser(@PathParam("id") Long id);
}
