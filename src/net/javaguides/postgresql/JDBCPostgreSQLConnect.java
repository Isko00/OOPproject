package net.javaguides.postgresql;

import java.sql.*;

public class JDBCPostgreSQLConnect {
	public static void main(String[] args) throws SQLException {
	    final String user = "postgres";
	    final String password = "postgres";
	    final String url = "jdbc:postgresql://localhost/university_system";
	    final Connection connection = DriverManager.getConnection(url, user, password);
	
	    String result = "";
	    
	    try (PreparedStatement statement =
	    		connection.prepareStatement("SELECT * FROM users")) {
	    		//connection.prepareStatement("INSERT INTO users (id, password, role) VALUES (DEFAULT, '229', 1)")) {
	    	//statement.setInt(1, 2);
	    	//statement.executeUpdate();
	    	
	    	final ResultSet resultSet = statement.executeQuery();
	
	        while (resultSet.next()) {
	            String byName = "id: " + resultSet.getString("id");
	            String byIndex = "password: " + resultSet.getString(2);
	            final int role = resultSet.getInt("role");
	            result += byName + " ";
	            result += byIndex + " ";
	            result += "role: " + role + "/n";
	        }
			
	    } finally {
	        connection.close();
	    }
	
	    System.out.println(result);
	}
}
