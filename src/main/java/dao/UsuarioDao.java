package dao;

import database.Conexaobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {
    public boolean verificarLogin(String nome, String senha){
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";

        try(Connection conn = Conexaobd.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, nome);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e){
            e.printStackTrace();
        } return false;


    }
}
