package com.example.Omega.login;

import java.sql.DriverManager;
import java.sql.Statement;

public class SqlConnection {
    public Statement getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/omega", "root", "").createStatement();
		} catch (Exception e) {
			System.out.println(e);

		}
		return null;

	}
}
