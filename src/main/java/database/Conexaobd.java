package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexaobd {
    public static Connection conectar(){
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:C:/temp/java-intellij/projetofay/bd_fay.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado ao SQLite!");

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return conn;

    }
}
