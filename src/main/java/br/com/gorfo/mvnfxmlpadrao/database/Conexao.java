package br.com.gorfo.mvnfxmlpadrao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException {
        if (connection == null){
            return conectar();
        }else{
            return connection;
        }
    }
    
    public static Connection conectar() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/atendimento?useTimezone=true&serverTimezone=UTC","Gorfo","123");
            System.out.println("Conectado com sucesso");
            return connection;
        }catch(SQLException e){
            System.out.println("Erro ao conectar: "+e);
            return null;
        }
    }
    
    public static void desconectar(){
        try{
            connection.close();
            System.out.println("Desconectado com sucesso!");
        }catch(SQLException e){
            System.out.println("Erro ao desconectar: "+e);
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        Conexao.getConnection();
        Conexao.desconectar();
    }
}
