package com.simple.provider;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.simple.api.UserService;
import com.simple.model.User;

@Path("users")
public class UserServiceImpl implements UserService {

	@POST
	@Path("register")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void registerUser(User user) {
		// save the user...
	}

	@GET
	@Path("{id : \\d+}")
	@Produces({ MediaType.APPLICATION_JSON })
	public User getUser(@PathParam("id") Long id) {
		User u = new User();
		return u;
	}
}