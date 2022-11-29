package com.cts.tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TweetDaoImpl implements TweetDao {

	@Override
	public String userRigistration(String firstName, String email, String password) {

		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false",
					"root", "root");

			PreparedStatement stmt = con.prepareStatement("insert into Emp values(?,?,?)");
			stmt.setString(1, firstName);// 1 specifies the first parameter in the query
			stmt.setString(2, email);
			stmt.setString(3, password);

			i = stmt.executeUpdate();
			System.out.println(i + "Records was inserted succesfully.");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return String.valueOf(i);
	}

}
