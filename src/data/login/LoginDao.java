/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.login;

import data.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class LoginDao extends Database{
    private PreparedStatement statment = getStatment();
    private Connection conn = getConn();
    private ResultSet contentResult;

    public int salvar(Login login){
        conectar();
        int status;
        try {
            statment = conn.prepareStatement("INSERT INTO login(usuario,senha,ra)  VALUES(?,?,?)");
            statment.setString(1, login.getUsuario());
            statment.setString(2, login.getSenha());
            statment.setString(3, login.getRa());
            status = statment.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            status = ex.getErrorCode();
        }finally{
            desconectar();
        }
        return status;
    }
    
    public Login consulta(String usuario){
        conectar();
        Login login= new Login();
        
        try {
            statment = conn.prepareStatement("SELECT * FROM login WHERE usuario = ?");
            statment.setString(1, usuario);
            contentResult = statment.executeQuery();
            if(contentResult.next()){
                login.setUsuario(contentResult.getString("usuario"));
                login.setSenha(contentResult.getString("senha"));
                login.setRa(contentResult.getString("ra"));
            }else{
                login=null;
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex);
            login = null;
        }finally{
            desconectar();
        }
        
        return login;
    }
}
