package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public static List<Projetos> findByPk(int id) {
		sql = "SELECT * FROM projetos WHERE fk_Organizador_Id_Organizador=?";
		
		List<Projetos> projetos = new ArrayList<Projetos>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Projetos projeto = new Projetos();
				projeto.setId_projeto(rs.getInt("Id_projeto"));
				projeto.setNome(rs.getString("Nome"));
				projeto.setObjetivo(rs.getDouble("Objetivo"));
				projeto.setArrecadado(rs.getDouble("Arrecadado"));
				projetos.add(projeto);
			}
			
		System.out.println("--Correct find projetos");
		return projetos;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find projetos. " + e.getMessage());
			return null;
		}
	}
}
