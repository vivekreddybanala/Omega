package com.example.Omega.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

	@RequestMapping(method = RequestMethod.GET, path = "/Login")
	public String LoginDetails() {
		return "Login Success";
	}

	@PostMapping("/login")
	public String LoginCheck(@RequestBody LoginDetails loginDetails) {
		try {

			Statement Conn = new SqlConnection().getConn();
			String query="select * from omega.Users where username='" + loginDetails.getUsername()
			+ "' and password='" + loginDetails.getPassword()+"'";
			ResultSet rs = Conn.executeQuery(query);
			String result = "Login Success for ";
			if (rs.next()) {
				result+=rs.getString(2);
			}
			Conn.close();
			return result;
		} catch (Exception e) {
			return "Login Failed for " + loginDetails.getUsername() + e;
		}
	}
}

class LoginDetails {
	public String username;
	public String password;

	LoginDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}
