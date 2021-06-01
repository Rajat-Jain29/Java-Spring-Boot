package com.example.demo.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class control {

	Statement statement;

	@GetMapping("/metadata")
	public void metaData(HttpServletResponse res) throws SQLException, IOException {
		String url = "jdbc:oracle:thin:@localhost:1521:";
		String username = "system";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, username, password);
		statement = conn.createStatement();

	
		String query = "select * from all_users order by CREATED DESC";
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()) {
			System.out.println("Name of Database : "+ rs.getString(1) + " ------->>> " + "Creation time : "+ rs.getString(3) );
		}
		
System.out.println();
		
//		
		DatabaseMetaData metadata = conn.getMetaData();
		DatabaseMetaData meta = conn.getMetaData();

		String productName = meta.getDatabaseProductName();
		String productVersion = meta.getDatabaseProductVersion();
		System.out.println();
		System.out.println("===============DESCRIPTIVE METADATA=================\n");
		res.getWriter().print(productName + " " + productVersion);
		System.out.println(productName + " " + productVersion);
		System.out.println("Username of DataBase:  " + meta.getUserName());
		System.out.println("Maximum number of column that allows group by clause : " + meta.getMaxColumnsInGroupBy());
		System.out.println("Maximum length of User Name : " + meta.getMaxUserNameLength());
		System.out.println("Procedure term of Database : " + meta.getProcedureTerm());
		System.out.println("Keywords Of Oracle Database: " + meta.getSQLKeywords());
		System.out.println("Functions in Oracle Database :" + meta.getStringFunctions());
		System.out.println("URL for this Database :" + meta.getURL());
		System.out.println("Tells whether Database is in read mode or not: " + meta.isReadOnly());
		System.out.println("Catalog/ResultSet of DataBase : " + meta.getCatalogs());

		int majorVersion = meta.getDatabaseMajorVersion();
		int minorVersion = meta.getDatabaseMinorVersion();
		res.getWriter().print("Database version: " + majorVersion + " " + minorVersion + "\n");
		System.out.println("Database version: " + majorVersion + " " + minorVersion);

		String driverName = meta.getDriverName();
		String driverVersion = meta.getDriverVersion();

		res.getWriter().print("Driver Info: " + driverName + " - " + driverVersion);
		System.out.println("Driver Info: " + driverName + " - " + driverVersion);

		int jdbcMajorVersion = meta.getJDBCMajorVersion();
		int jdbcMinorVersion = meta.getJDBCMinorVersion();

		res.getWriter().print("JDBC Version: " + jdbcMajorVersion + "." + jdbcMinorVersion);
		System.out.println("JDBC Version: " + jdbcMajorVersion + "." + jdbcMinorVersion);

		System.out.println();
		
		String catalog = null, schemaPattern = null, tableNamePattern = null;
		String[] types = { "TABLE" }; // and SYSTEM_TABLE is for already table ; TABLE is for user - defined .
		ResultSet Tables = metadata.getTables(catalog, schemaPattern, tableNamePattern, types);
//			
//			while (Tables.next()) {
//				String tableName = Tables.getString(3);
//				res.getWriter().print(" TABLE: " + tableName);
//				System.out.println(" TABLE: " + tableName);
		// String columnNamePattern = null;
//				
//
//
//				
//				String q = "SELECT create_time FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = 'hack' AND table_name='"
//						+ tableName + "' ";
//				ResultSet rs = statement.executeQuery(q);
//				while (rs.next()) {
//					System.out.println("Date and Time of " + tableName + " :" + rs.getString("create_time"));
//				}
//				
		while (Tables.next()) {
			String tableName = Tables.getString(3);
//				res.getWriter().print(" TABLE: " + tableName);
//				System.out.println(" TABLE: " + tableName);
			String columnNamePattern = null;

			System.out.println(" TABLE: " + tableName);
			
			// For Table Size: 
//	
//			String e = " SELECT pg_size_pretty( pg_total_relation_size('"+tableName+"') );";
//				ResultSet tp = statement.executeQuery(e);
//				tp.next();
//					System.out.println("Size of table : "+tp.getString("pg_size_pretty") );
				
				

			ResultSet Columns = metadata.getColumns(catalog, schemaPattern, tableName, columnNamePattern);
			while (Columns.next()) {

				String columnName = Columns.getString("COLUMN_NAME");
				String columnType = Columns.getString("TYPE_NAME");
				int columnSize = Columns.getInt("COLUMN_SIZE");
				
				System.out.println("\t" + columnName + " - " + columnType + "(" + columnSize + ")"
						+ " ---Descriptive Metadata => " + tableName + " " + columnName);
			}

			ResultSet PK = metadata.getPrimaryKeys(catalog, schemaPattern, tableName);
			while (PK.next()) {
				System.out.println(PK.getString("PK_NAME") + "=" + PK.getString("COLUMN_NAME"));
			}

			System.out.println("Schema of Tables : " + meta.getSchemas());
			System.out.println("\n====================================================\n");

		}

//			}


		
}
	
}
