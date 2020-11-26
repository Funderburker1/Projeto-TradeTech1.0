/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class Database {
    private PreparedStatement statment;
    private Connection conn;
//    private String typeDb = "postgresql";;
    private String typeDb = "sqlite";

    public Database() {
        conectar();
    }

    public PreparedStatement getStatment() {
        return statment;
    }

    public void setStatment(PreparedStatement statment) {
        this.statment = statment;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
    public boolean conectar(){
        try {
            if(typeDb.equalsIgnoreCase("postgresql")){
                Class.forName("org.postgresql.Driver");
                setConn(DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto","POSTGRES_USER","POSTGRES_PASSWORD"));
            }else if(typeDb.equalsIgnoreCase("mysql")){
                Class.forName("com.mysql.jdbc.Driver");
                setConn(DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto","root","MYSQL_ROOT"));
            }else{
//                setConn(DriverManager.getConnection("jdbc:sqlite:BancoDados/banco.db"));
                setConn(DriverManager.getConnection("jdbc:sqlite:banco.db"));
            }
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "ERRO!! \n Falha so se conectar com o banco de dados");
            return false;
        }
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex){
            
        }
    }
}
