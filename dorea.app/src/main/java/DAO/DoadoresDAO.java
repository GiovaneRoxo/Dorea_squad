package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		sql = "DELETE FROM doadores WHERE Id_doadores = ?";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id_doadores);
			ps.executeUpdate();
			
			System.out.println("--Correct delete on cliente");
			
		} catch(SQLException e) {
			System.out.println("--Incorrect delete on cliente. " + e.getMessage());
		}
	}	
	
	public static Doadores findByPk(int id_doadores) {
		sql = String.format("SELECT * FROM doadores WHERE Id_doadores = %d ", id_doadores);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			Doadores doador = new Doadores();
			
			while(rs.next()) {
				doador.setId_doadores(rs.getInt("Id_doadores"));
				doador.setNome(rs.getString("Nome"));
				doador.setSobrenome(rs.getString("Sobrenome"));
				doador.setCpf(rs.getString("Cpf"));
				doador.setEmail(rs.getString("Email"));
				doador.setTelefone(rs.getString("Telefone"));
				doador.setSenha(rs.getString("Senha"));
			}
			
		System.out.println("--Correct find by pk doadores");
		return doador;
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find by pk doadores. " + e.getMessage());
			return null;
		}		
	}
	
	public static void update(Doadores doador) {
		
		sql = "UPDATE doadores SET nome=?, Sobrenome=?, cpf=?, email=?, Telefone=?, senha=? WHERE Id_doadores=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, doador.getNome());
			preparedStatement.setString(2, doador.getSobrenome());
			preparedStatement.setString(3, doador.getCpf());
			preparedStatement.setString(4, doador.getEmail());
			preparedStatement.setString(5, doador.getTelefone());
			preparedStatement.setString(6, doador.getSenha());
			preparedStatement.setInt(7, doador.getId_doadores());
			preparedStatement.executeUpdate();
			
			System.out.println("--corect update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorect update on database. " + e.getMessage());
		}
	}

	public static boolean loginValidar(String email, String senha) {
		sql = "SELECT * FROM doadores WHERE email = ? AND senha = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

	public static String returnarNomeByEmail(String email) {
		sql = "SELECT * FROM doadores WHERE email = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				System.out.println("--Nome achado com sucesso. ");
				String NomeCompleto = rs.getString("Nome") + " " + rs.getString("Sobrenome");
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
		
		sql = "SELECT * FROM doadores WHERE Email=? ";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet rs =preparedStatement.executeQuery();
			Doadores doador = new Doadores();
			
			while(rs.next()) {
				doador.setId_doadores(rs.getInt("Id_doadores"));
			}
			
			System.out.println("--Correct find ID by email.");
			return doador.getId_doadores();
			
		} catch(SQLException e) {
			System.out.println("--Incorrect find ID by email. " + e.getMessage());
			return (Integer) null;
		}
	}
}
