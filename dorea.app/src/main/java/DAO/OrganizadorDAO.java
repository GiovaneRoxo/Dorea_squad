package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.MySqlConnection;
import model.Doadores;
import model.Organizador;

public class OrganizadorDAO {

	private static Connection con = MySqlConnection.createConnection();
	private static String sql;
	
	public static void criarOrganizador(Organizador organizador) {		
		sql = "INSERT INTO organizador VALUES (null, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, organizador.getNome());
			preparedStatement.setString(2, organizador.getCnpj());
			preparedStatement.setString(3, organizador.getEmail());
			preparedStatement.setString(4, organizador.getTelefone());
			preparedStatement.setString(5, organizador.getSenha());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--corect insert organizador on database");
			
		} catch(SQLException e) {
			System.out.println("--incorect insert organizador on database. " + e.getMessage());
		}
	}
}
