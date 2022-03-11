package com.codeexrcise.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String args[]) throws SQLException {

		

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con = DriverManager.getConnection("databaseName", "userName", "password");
		Statement st = con.createStatement();

		PreparedStatement pst = con.prepareStatement("insert into table_name (id,firstname,secondname) values (?,?,?)");

		pst.setInt(1, 1500);
		pst.setString(2, "Mathews");
		pst.setString(3, "George");

		ResultSet set = st.executeQuery("select * from table_name");
		while (set.next()) {
			System.out.println(set.getString(1));
		}
		st.execute("delete from table_name  where id = 1");
		st.close();
		pst.close();
		con.close();
	}

}
