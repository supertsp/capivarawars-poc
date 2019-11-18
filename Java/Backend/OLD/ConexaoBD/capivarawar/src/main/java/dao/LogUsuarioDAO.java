package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LogUsuarioDAO extends Conexao {

	private Conexao con = new Conexao();

	public void LogUsuario() throws SQLException {

		Connection connection = con.getConnection();

		PreparedStatement st = connection.prepareStatement("SELECT * FROM LogUsuario where ID_TIME_TEMPO = 12;");

		ResultSet rs = st.executeQuery();
		System.out.println("Exibindo Resultado do SELECT * FROM LogUsuario where ID_TIME_TEMPO = 12");

		while (rs.next()) {
			

			System.out.println(rs.getString("dat_dia_hr"));
		}

	}

	@Override
	public String toString() {
		return "LogUsuarioDAO [con=" + con + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
