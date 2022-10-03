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
	
	public static Projetos buscaByPk(int id_projeto) {
		sql = String.format("SELECT * FROM projetos WHERE Id_projeto= %d ", id_projeto);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			Projetos projetos = new Projetos();
			
			while(rs.next()) {
				projetos.setId_projeto(rs.getInt("Id_projeto"));
				projetos.setNome(rs.getString("Nome"));
				projetos.setObjetivo(rs.getDouble("Objetivo"));
				projetos.setArrecadado(rs.getDouble("Arrecadado"));
				projetos.setFk_Organizador_Id_organizador(rs.getInt("fk_Organizador_Id_organizador"));
			}
			
		System.out.println("--Correct find by pk projetos");
		return projetos;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find by pk projetos. " + e.getMessage());
			return null;
		}		
	}
	
	public static void Atualizar(Projetos projeto) {
		sql = "UPDATE projetos SET Nome = ?, Objetivo = ? WHERE Id_projeto=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, projeto.getNome());
			stmt.setDouble(2, projeto.getObjetivo());
			stmt.setInt(3, projeto.getId_projeto());
			stmt.executeUpdate();
			
			System.out.println("correct update project");
		} catch(Exception e) {
			System.out.println("failed update project" + e.getMessage());
		}
	}
	
	public static void deletarProjeto(int id_projeto){	
		sql = "DELETE FROM projetos WHERE Id_projeto = ?";
		
		try {		
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id_projeto);
			ps.executeUpdate();
			
			System.out.println("--Correct delete on projeto");			
		} catch (SQLException e) {
			System.out.println("--Incorrect delete on projeto. " + e.getMessage());
		}
	}
	
	public static ArrayList<Projetos> listarTodos() {
        
	    ArrayList<Projetos> projetos = new ArrayList<Projetos>();
	    
	    sql = "SELECT * FROM projetos";
	    
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Projetos projeto = new Projetos();
	            projeto.setId_projeto(rs.getInt(1));
	            projeto.setNome(rs.getString(2));
	            projeto.setObjetivo(rs.getDouble(3));
	            projeto.setArrecadado(rs.getDouble(4));
	            projeto.setFk_Organizador_Id_organizador(rs.getInt(5));
	            projetos.add(projeto);
	        }
	        System.out.println("--Busca realizada!");
	        return projetos;
	    } catch(Exception e) {
	        System.out.println("--Falha ao realizar busca" + e.getMessage());
	        return null;
	    }
	  
	}
}
