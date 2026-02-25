package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "productDAO")
@ApplicationScoped
public class ProductDAO {
	
	private static final String URL_DATABASE = "jdbc:oracle:thin:@relain.azl.upct.es:1521:relain";
	private static final String URL_DATABASE2 = "jdbc:oracle:thin:@pentaho.azl.upct.es:1521:pentaho";
	private static final String USER = "otri";
	private static final String USER2 = "PENTAHODW";
	private static final String PASS = "uy5bn74fwng";
	private static final String PASS2 = "pentahodw99";
	
	static {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        } 
        catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Product> findAll() {
		String nombreTabla = "tabla_blobs";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Product> products = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(URL_DATABASE, USER, PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from " + nombreTabla + " fetch first 10 rows only");
			ResultSetMetaData meta = resultSet.getMetaData();
			int columnCount = meta.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String columnName = meta.getColumnName(i);
				String columnType = meta.getColumnTypeName(i);
				System.out.println(columnName + " -> " + columnType);
			}
			while(resultSet.next()) {
				Long id = resultSet.getLong("Codigo");
				String name = resultSet.getString("NOMBRE_LOCAL");
				Double price = 10.0;
				Product p = new Product(id,name,price);
				products.add(p);
			}
		 } catch (SQLException e) {
            e.printStackTrace();
		 }
		finally {
			
			try { if(resultSet != null) resultSet.close(); }  catch (Exception e) {}
			try { if(statement != null) statement.close(); }  catch (Exception e) {}
			try { if(connection != null) connection.close(); }  catch (Exception e) {}
		}
		return products;
	}	
	
	
	
	
}
