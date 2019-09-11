package aplication;

import java.sql.SQLException;



import dao.LogUsuarioDAO;

public class Main {

	public static void main(String[] args) throws SQLException {

		LogUsuarioDAO con = new LogUsuarioDAO();
		
//		con.getConnection();
		con.LogUsuario();
		
		
	}

}