package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.MySqlConnection;
import model.Projetos;

public class ProjetoDAO {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void criarProjeto(Projetos projeto) {
		sql = "INSERT INTO projetos VALUES (null, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, projeto.getNome());
			preparedStatement.setDouble(2, projeto.getObjetivo());
			preparedStatement.setDouble(3, projeto.getArrecadado());
			preparedStatement.setInt(4, projeto.getFk_Organizador_Id_organizador());
			preparedStatement.executeUpdate();
			System.out.println("--corect insert on database");
		} catch(SQLException e) {
			System.out.println("--incorect insert on database. " + e.getMessage());
		}	
	}
}
