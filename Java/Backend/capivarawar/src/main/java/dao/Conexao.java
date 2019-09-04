package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection getConnection() throws SQLException {

		// Connect to database
		String hostName = "kingsofriver.database.windows.net"; // update me
		String dbName = "KingsOfRiver"; // update me
		String user = "kingadmin"; // update me
		String password = "!Kings121"; // update me
		String url = String.format(
				"jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
						+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
				hostName, dbName, user, password);

		return DriverManager.getConnection(url);
	}
	
}
