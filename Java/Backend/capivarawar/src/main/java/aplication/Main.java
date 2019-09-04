package aplication;

import java.sql.SQLException;

import dao.Conexao;

public class Main {

	public static void main(String[] args) throws SQLException {

		Conexao con = new Conexao();
		
		con.getConnection();
		
	}

}
