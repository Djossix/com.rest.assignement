package com.rest.assignement;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/UserService")

public class UserService {

	UserDao userDao = new UserDao();

	@GET
	@Path("/adduser")
	@Produces(MediaType.APPLICATION_XML)
	public void addUser() throws SQLException, ClassNotFoundException {
		userDao.addUser(1, "Jessica", "Developer");
	}
	
	@GET
	@Path("/getuser")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() throws SQLException, ClassNotFoundException {
		return userDao.getUser();
	}
	
}
