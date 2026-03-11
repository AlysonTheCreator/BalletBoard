package main;

import database.Conexaobd;
import view.TelaLogin;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        new TelaLogin();

        Connection conn = Conexaobd.conectar();

        if(conn != null){
            System.out.println("Conesaxão funcionando!");
        }



    }
}