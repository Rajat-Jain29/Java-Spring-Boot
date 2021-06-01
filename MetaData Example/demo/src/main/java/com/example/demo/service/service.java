package com.example.demo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.Statement;

@RestController
public class service {
	Statement statement;
	@GetMapping("/metadata")
	public void metaData(HttpServletResponse res) throws SQLException, IOException {
		String url = "jdbc:mysql://localhost:3306/hack";
		String username = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, username, password);

		DatabaseMetaData metadata = conn.getMetaData();
		DatabaseMetaData meta = conn.getMetaData();

		System.out.println("\n====================================================\n");

		statement = (Statement) conn.createStatement();

		String f = "show databases";
		System.out.println("Total Databases : \n");
		ResultSet t = statement.executeQuery(f);
		while (t.next()) {
			System.out.println(t.getString("Database"));
		}
		System.out.println();
		// st.executeQuery(q);
		String p = "show grants";
		ResultSet r = statement.executeQuery(p);
		System.out.println("For root user : ");
		while (r.next()) {
			System.out.println(r.getString("Grants for root@localhost"));
		}
		System.out.println();

		String h = "show grants FOR 'Rajat'@'localhost'";
		ResultSet set = statement.executeQuery(h);
		System.out.println("For Rajat as user : ");
		while (set.next()) {
			System.out.println(set.getString("Grants for Rajat@localhost"));
		}

		System.out.println();

		String show = "show grants FOR 'user'@'localhost'";
		ResultSet setresult = statement.executeQuery(show);
		System.out.println("For normal user : ");
		while (setresult.next()) {
			System.out.println(setresult.getString("Grants for user@localhost"));
		}

		System.out.println();

		System.out.println("Size of Tables in hack database :");
		String qw = "SELECT TABLE_NAME AS 'Table',  ROUND((DATA_LENGTH + INDEX_LENGTH) / 1024 ) AS 'Size (KB)' FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'hack' ORDER BY (DATA_LENGTH + INDEX_LENGTH) DESC;";
		ResultSet rset = statement.executeQuery(qw);
		while (rset.next()) {
			System.out.println(rset.getString("Table") + " ---> " + rset.getString("Size (KB)") + " KB");
		}

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
		System.out.println("Keywords Of MySQL Database: " + meta.getSQLKeywords());
		System.out.println("Functions in MySQL Database :" + meta.getStringFunctions());
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
		System.out.println("===============ADMINISTRATIVE METADATA=================\n");
		String catalog = null, schemaPattern = null, tableNamePattern = null;
		String[] types = { "TABLE" }; // and SYSTEM_TABLE is for already table ; TABLE is for user - defined .
		ResultSet Tables = metadata.getTables(catalog, schemaPattern, tableNamePattern, types);

		Tables.next();

		String tableNam = Tables.getString(3);
		res.getWriter().print(" TABLE: " + tableNam);
		System.out.println(" TABLE: " + tableNam);
		String qu = "SELECT create_time FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = 'hack' AND table_name='"
				+ tableNam + "' ";
		ResultSet rse = statement.executeQuery(qu);
		while (rse.next()) {
			System.out.println("Date and Time of " + tableNam + " :" + rse.getString("create_time"));
		}

		ResultSet Column = metadata.getColumns(catalog, schemaPattern, tableNam, null);
		while (Column.next()) {
			String columnNam = Column.getString("COLUMN_NAME");
			String columnTyp = Column.getString("TYPE_NAME");
			int columnSiz = Column.getInt("COLUMN_SIZE");
			res.getWriter().print("\t" + columnNam + " - " + columnTyp + "(" + columnSiz + ")");
			System.out.println("\t" + columnNam + " - " + columnTyp + "(" + columnSiz + ")");
		}
		System.out.println();
		System.out.println("===============STRUCTURAL METADATA=================\n");
		while (Tables.next()) {
			String tableName = Tables.getString(3);
			res.getWriter().print(" TABLE: " + tableName);
			System.out.println(" TABLE: " + tableName);
			String columnNamePattern = null;
			String q = "SELECT create_time FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = 'hack' AND table_name='"
					+ tableName + "' ";
			ResultSet rs = statement.executeQuery(q);
			while (rs.next()) {
				System.out.println("Date and Time of " + tableName + " :" + rs.getString("create_time"));
			}

			ResultSet Columns = metadata.getColumns(catalog, schemaPattern, tableName, columnNamePattern);
			while (Columns.next()) {

				String columnName = Columns.getString("COLUMN_NAME");
				String columnType = Columns.getString("TYPE_NAME");
				int columnSize = Columns.getInt("COLUMN_SIZE");
				res.getWriter().print("\t" + columnName + " - " + columnType + "(" + columnSize + ")");
				System.out.println("\t" + columnName + " - " + columnType + "(" + columnSize + ")"
						+ " ---Descriptive Metadata => " + tableName + " " + columnName);
//				 String columnName = Columns.getString("COLUMN_NAME");
//				    String datatype = Columns.getString("DATA_TYPE");
//				    String columnsize = Columns.getString("COLUMN_SIZE");
//				    String decimaldigits = Columns.getString("DECIMAL_DIGITS");
//				    String isNullable = Columns.getString("IS_NULLABLE");
//				    String is_autoIncrment = Columns.getString("IS_AUTOINCREMENT");
//				    //Printing results
//				    System.out.println(columnName + "---" + datatype + "---" + columnsize + "---" + decimaldigits + "---" + isNullable + "---" + is_autoIncrment);
			}

			ResultSet PK = metadata.getPrimaryKeys(catalog, schemaPattern, tableName);
			while (PK.next()) {
				res.getWriter().print(PK.getString("COLUMN_NAME") + "=" + PK.getString("PK_NAME"));
				System.out.println(PK.getString("PK_NAME") + "=" + PK.getString("COLUMN_NAME"));
			}

			System.out.println("Schema of Tables : " + meta.getSchemas());
			System.out.println("\n====================================================\n");

		}

	}

//	@GetMapping("/metadata/mongoDB")
//	public void data() {
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		System.out.println("Created Mongo Connection successfully");
//		MongoDatabase db = mongoClient.getDatabase("youtube");
//		System.out.println("Get database is successful");
//		MongoCollection<org.bson.Document> collection = db.getCollection("channels");
//		System.out.println("Database Connected");
//
//	}

	@GetMapping("/metadata/Rajat")
	public void da() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String username = "Rajat";
		String password = "password";
		Connection conn = DriverManager.getConnection(url, username, password);

		DatabaseMetaData metadata = conn.getMetaData();
		DatabaseMetaData meta = conn.getMetaData();

		System.out.println("\n====================================================\n");

		statement = (Statement) conn.createStatement();

		String f = "show databases";
		ResultSet t = statement.executeQuery(f);
		while (t.next()) {
			System.out.println(t.getString("Database"));
		}

		String h = "show grants FOR 'Rajat'@'localhost'";
		ResultSet set = statement.executeQuery(h);
		System.out.println("For new user : ");
		while (set.next()) {
			System.out.println(set.getString("Grants for Rajat@localhost"));
		}

		System.out.println();

		System.out.println("Size of Tables in database of userrajat :");
		String qw = "SELECT TABLE_NAME AS 'Table',  ROUND((DATA_LENGTH + INDEX_LENGTH) / 1024 ) AS 'Size (KB)' FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'userrajat' ORDER BY (DATA_LENGTH + INDEX_LENGTH) DESC;";
		ResultSet rset = statement.executeQuery(qw);
		while (rset.next()) {
			System.out.println(rset.getString("Table") + " ---> " + rset.getString("Size (KB)") + " KB");
		}

	}

	@GetMapping("/metadata/user")
	public void dat() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String username = "user";
		String password = "password";
		Connection conn = DriverManager.getConnection(url, username, password);

		DatabaseMetaData metadata = conn.getMetaData();
		DatabaseMetaData meta = conn.getMetaData();

		System.out.println("\n====================================================\n");

		statement = (Statement) conn.createStatement();

		String f = "show databases";
		ResultSet t = statement.executeQuery(f);
		while (t.next()) {
			System.out.println(t.getString("Database"));
		}

		String h = "show grants FOR 'user'@'localhost'";
		ResultSet set = statement.executeQuery(h);
		System.out.println("For normal user : ");
		while (set.next()) {
			System.out.println(set.getString("Grants for user@localhost"));
		}

		System.out.println();

		System.out.println("Size of Tables in database of user :");
		String qw = "SELECT TABLE_NAME AS 'Table',  ROUND((DATA_LENGTH + INDEX_LENGTH) / 1024 ) AS 'Size (KB)' FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'hack' ORDER BY (DATA_LENGTH + INDEX_LENGTH) DESC;";
		ResultSet rset = statement.executeQuery(qw);
		while (rset.next()) {
			System.out.println(rset.getString("Table") + " ---> " + rset.getString("Size (KB)") + " KB");
		}
	}
}