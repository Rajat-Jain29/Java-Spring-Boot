package com.example.demo.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {

	Statement statement;

	@GetMapping("/metadata")
	public void metaData(HttpServletResponse res) throws SQLException, IOException {
		String url = "jdbc:postgresql://localhost:5432/test";
		String username = "postgres";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, username, password);
		statement = conn.createStatement();

		String f = "SELECT datname FROM pg_database;";
		System.out.println("Total Databases : \n");
		ResultSet t = statement.executeQuery(f);
		
		while (t.next()) {
			System.out.println(t.getString("datname") );
			// For Database Size : 
			
	//	String e = " SELECT pg_size_pretty( pg_database_size('"+t.getString("datname") +"') );";
	//	ResultSet tp = statement.executeQuery(e);
	//	tp.next();
	//		System.out.println(tp.getString("pg_size_pretty") );
		
		}
		System.out.println();
		
		String u ="select pg_database.datname,pg_user.usename,pg_encoding_to_char(pg_database.encoding),pg_database.datcollate,pg_database.datctype,pg_database.datacl from pg_database,pg_user WHERE pg_database.datdba = pg_user.usesysid;";
		ResultSet ts = statement.executeQuery(u);
		while (ts.next()) {    
			System.out.println(ts.getString("datname") + "   " + ts.getString("usename")+ "   " + ts.getString("pg_encoding_to_char") + "   "+ ts.getString("datcollate") + "   "+ ts.getString("datctype") + "   " + ts.getString("datacl") );			
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
		System.out.println("Keywords Of Postgres Database: " + meta.getSQLKeywords());
		System.out.println("Functions in Postgres Database :" + meta.getStringFunctions());
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
	
			String e = " SELECT pg_size_pretty( pg_total_relation_size('"+tableName+"') );";
				ResultSet tp = statement.executeQuery(e);
				tp.next();
					System.out.println("Size of table : "+tp.getString("pg_size_pretty") );
				
				

			ResultSet Columns = metadata.getColumns(catalog, schemaPattern, tableName, columnNamePattern);
			while (Columns.next()) {

				String columnName = Columns.getString("COLUMN_NAME");
				String columnType = Columns.getString("TYPE_NAME");
				int columnSize = Columns.getInt("COLUMN_SIZE");
				res.getWriter().print("\t" + columnName + " - " + columnType + "(" + columnSize + ")");
				System.out.println("\t" + columnName + " - " + columnType + "(" + columnSize + ")"
						+ " ---Descriptive Metadata => " + tableName + " " + columnName);
			}

			ResultSet PK = metadata.getPrimaryKeys(catalog, schemaPattern, tableName);
			while (PK.next()) {
				res.getWriter().print(PK.getString("COLUMN_NAME") + "=" + PK.getString("PK_NAME"));
				System.out.println(PK.getString("PK_NAME") + "=" + PK.getString("COLUMN_NAME"));
			}

			System.out.println("Schema of Tables : " + meta.getSchemas());
			System.out.println("\n====================================================\n");

		}

//			}
	}

	
	//ALTER SESSION SET current_schema = other_user;  SELECT table_name
	  //    FROM user_tables;
	
	@GetMapping("/metadata/myuser")
	public void metaDta(HttpServletResponse res) throws SQLException, IOException {
		String url = "jdbc:postgresql://localhost:5432/";
		String username = "myuse";
		String password = "mypass";
		Connection conn = DriverManager.getConnection(url, username, password);
		statement = conn.createStatement();
		
	String f = "SELECT datname FROM pg_database;";
	
	
		System.out.println("Total Databases : \n");
		ResultSet t = statement.executeQuery(f);
		while (t.next()) {
			System.out.println(t.getString("datname"));
		}
		System.out.println();
		
		DatabaseMetaData metadata = conn.getMetaData();
		String catalog = null, schemaPattern = null, tableNamePattern = null;
		String[] types = { "TABLE" }; // and SYSTEM_TABLE is for already table ; TABLE is for user - defined .
		ResultSet Tables = metadata.getTables(catalog, schemaPattern, tableNamePattern, types);
		while (Tables.next()) {
			String tableName = Tables.getString(3);
//				res.getWriter().print(" TABLE: " + tableName);
//				System.out.println(" TABLE: " + tableName);
			String columnNamePattern = null;

			System.out.println(" TABLE: " + tableName);
			
			String e = " SELECT pg_size_pretty( pg_total_relation_size('"+tableName+"') );";
			ResultSet tp = statement.executeQuery(e);
			tp.next();
			System.out.println("Size of table : "+tp.getString("pg_size_pretty") );

			ResultSet Columns = metadata.getColumns(catalog, schemaPattern, tableName, columnNamePattern);
			while (Columns.next()) {

				String columnName = Columns.getString("COLUMN_NAME");
				String columnType = Columns.getString("TYPE_NAME");
				int columnSize = Columns.getInt("COLUMN_SIZE");
				res.getWriter().print("\t" + columnName + " - " + columnType + "(" + columnSize + ")");
				System.out.println("\t" + columnName + " - " + columnType + "(" + columnSize + ")"
						+ " ---Descriptive Metadata => " + tableName + " " + columnName);
			}

			ResultSet PK = metadata.getPrimaryKeys(catalog, schemaPattern, tableName);
			while (PK.next()) {
				res.getWriter().print(PK.getString("COLUMN_NAME") + "=" + PK.getString("PK_NAME"));
				System.out.println(PK.getString("PK_NAME") + "=" + PK.getString("COLUMN_NAME"));
			}

			System.out.println("Schema of Tables : " + metadata.getSchemas());
			System.out.println("\n====================================================\n");

		}
	}

}
