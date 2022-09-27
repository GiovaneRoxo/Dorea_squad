package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.MySqlConnection;
import model.Doadores;

public class DoadoresDAO implements CRUD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void criarDoador(Doadores doadores) {		
		sql = "INSERT INTO doadores VALUES (null, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, doadores.getNome());
			preparedStatement.setString(2, doadores.getSobrenome());
			preparedStatement.setString(3, doadores.getCpf());
			preparedStatement.setString(4, doadores.getEmail());
			preparedStatement.setString(5, doadores.getTelefone());
			preparedStatement.setString(6, doadores.getSenha());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--corect insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorect insert on database. " + e.getMessage());
		}
	}
	
	public static void deletarDoador(int id_doadores){	
	
	}	
	
	public static List<Doadores> find(String pesquisa) {
		return null;
	}
	
	public static Doadores findByPk(int id_doadores) {
		return null;
	}
	
	public static void update(Doadores doadores) {
		
	}
}
