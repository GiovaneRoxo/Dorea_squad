package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.MySqlConnection;
import model.Doacao;

public class DoacaoDAO {

    private static Connection connection = MySqlConnection.createConnection();
    private static String sql;

    public static void criarDoacao(Doacao doacao) {
        sql = "INSERT INTO Doacao VALUES (null, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, doacao.getValor());
            stmt.setInt(2, doacao.getFk_Doadores_Id_doadores());
            stmt.setInt(3, doacao.getFk_Projetos_Id_projeto());
            
            stmt.executeUpdate();
            System.out.println("--corect insert doação on database");
        } catch(SQLException e) {
            System.out.println("--incorect insert doação on database. " + e.getMessage());
        }   
    }
    
    public static ArrayList<Doacao> findByPk(int id) {
        sql = "SELECT * FROM Doacao WHERE fk_Doadores_Id_doadores=?";
        
        ArrayList<Doacao> doacoes = new ArrayList<Doacao>();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setId_doacao(rs.getInt(1));
                doacao.setValor(rs.getDouble(2));
                doacao.setFk_Doadores_Id_doadores(rs.getInt(3));
                doacao.setFk_Projetos_Id_projeto(rs.getInt(4));
                doacoes.add(doacao);
            }
            
        System.out.println("--Correct find doações");
        return doacoes;
            
        } catch(SQLException e) {
            System.out.println("--Incorrect find doações. " + e.getMessage());
            return null;
        }
    }
}
