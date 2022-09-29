package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.MySqlConnection;
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
	
	public static Organizador findByPk(int id_organizador) {
		sql = String.format("SELECT * FROM organizador WHERE Id_organizador = %d ", id_organizador);
		
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			Organizador organizador = new Organizador();
			
			while(rs.next()) {
				organizador.setId_organizador(rs.getInt("Id_organizador"));
				organizador.setNome(rs.getString("Nome"));
				organizador.setCnpj(rs.getString("Cnpj"));
				organizador.setEmail(rs.getString("Email"));
				organizador.setTelefone(rs.getString("Telefone"));
				organizador.setSenha(rs.getString("Senha"));
			}
			
		System.out.println("--Correct find by pk organizador");
		return organizador;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find by pk organizador. " + e.getMessage());
			return null;
		}		
	}

	public static boolean loginValidar(String email, String senha) {
		sql = "SELECT * FROM organizador WHERE email = ? AND senha = ?";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				System.out.println("--email e senha validados");
				return true;
			} else {
				System.out.println("--email ou senha incorretos");
				return false;
			}
			
			
			
		} catch(SQLException e) {
			System.out.println("--erro: " + e.getMessage());
			return false;
		}
	}
	
	public static void updateAdm(Organizador organizador) {
		
		sql = "UPDATE organizador SET Nome=?, Cnpj=?, Email=?, Telefone=?, Senha=? WHERE Id_organizador=?";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, organizador.getNome());
			preparedStatement.setString(2, organizador.getCnpj());
			preparedStatement.setString(3, organizador.getEmail());
			preparedStatement.setString(4, organizador.getTelefone());
			preparedStatement.setString(5, organizador.getSenha());
			preparedStatement.setInt(6, organizador.getId_organizador());
			preparedStatement.executeUpdate();
			
			System.out.println("--corect update organizador on database");
			
		} catch(SQLException e) {
			System.out.println("--incorect update organizador on database. " + e.getMessage());
		}
	}
	
	public static void deletarOrganizador(int id_organizador){	
		sql = "DELETE FROM organizador WHERE Id_organizador = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id_organizador);
			ps.executeUpdate();
			
			System.out.println("--Correct delete on organizador");
			
		} catch(SQLException e) {
			System.out.println("--Incorrect delete on organizador. " + e.getMessage());
		}
	}

	
	public static String returnarNomeByEmail(String email) {
		sql = "SELECT * FROM organizador WHERE email = ?";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				System.out.println("--Nome achado com sucesso. ");
				String NomeCompleto = rs.getString("Nome");
				return NomeCompleto;
			} else {
				System.out.println("--Nome nao achado. ");
				return null;
			}			
		} catch(SQLException e) {
			System.out.println("--erro: " + e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("null")
	public static int findIdByEmail(String email) {
		
		sql = "SELECT * FROM organizador WHERE Email=? ";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet rs =preparedStatement.executeQuery();
			Organizador organizador = new Organizador();
			
			while(rs.next()) {
				organizador.setId_organizador(rs.getInt("Id_organizador"));
			}
			
			System.out.println("--Correct find ID by email.");
			return organizador.getId_organizador();
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find ID by email. " + e.getMessage());
			return (Integer) null;
		}
	}
}
