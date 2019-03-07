package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Repository {
	protected Connection connection;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected void open() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Coffee?useUnicode=true&characterEncoding=UTF-8", "root", "");
	}
	protected void free() throws SQLException {
		if(rs != null) {
			rs.close();
			rs = null;
		}
		if(pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		if(stmt != null) {
			stmt.close();
			stmt = null;
		}
	}
	protected void close() {
		try {
			free();
			if(connection != null) {
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
