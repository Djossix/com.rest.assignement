package com.rest.assignement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {

	Connection con;
	
	private PreparedStatement statement;
	private String databaseUsername = "postgres";
	private String databasePassword = "Lx0e1utY";
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	
	public void addUser(int id, String name, String profession) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, databaseUsername, databasePassword);
		
		statement = con.prepareStatement(
				"INSERT INTO users (id, name, profession) VALUES (?, ?, ?) ON CONFLICT (id) DO NOTHING;");
		statement.setInt(1, id);
		statement.setString(2, name);
		statement.setString(3, profession);

		statement.execute();
		
	}

	public List<User> getUser(int i) throws SQLException, ClassNotFoundException {
		
		List<User> user = new ArrayList<>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, databaseUsername, databasePassword);
		
		ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE id = ?;");
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String profession = rs.getString(3);
			user.add(new User(id, name, profession));
		}
		
		return user;
	}
}
