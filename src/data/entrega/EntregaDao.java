/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.entrega;

import data.Database;
import data.produto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class EntregaDao extends Database{
    private PreparedStatement statment = getStatment();
    private Connection conn = getConn();
    private ResultSet contentResult;
    
    public int salvar(Entrega entrega) {
        conectar();
        int status;

        try {
            statment = conn.prepareStatement("INSERT INTO entregas(codigo_pedido,valor) VALUES(?,?)");
            statment.setInt(1, entrega.getCodigoPedido());
            statment.setDouble(2, entrega.getValor());
            status = statment.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            status = ex.getErrorCode();
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return status;
    }
    
    public int consultaProximoCodigo() {
        conectar();
        int codigo = 0;
        try {
            statment = conn.prepareStatement("SELECT * FROM sqlite_sequence where name='entregas'");
            contentResult = statment.executeQuery();
            codigo = contentResult.getInt("seq") + 1;
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return codigo;
    }
    
    public int updade(int codigo, String status) {
        int feedback;

        try {
            statment = conn.prepareStatement("UPDATE entregas SET status=? WHERE codigo = ?");
            statment.setString(1, status);
            statment.setInt(2, codigo);
            feedback = statment.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            feedback = ex.getErrorCode();
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return feedback;
    }
    
    public Entrega consulta(String codigo) {
        conectar();
        Entrega entrega = new Entrega();

        try {
            statment = conn.prepareStatement("SELECT * FROM entregas WHERE codigo = ?");
            statment.setString(1, codigo);
            contentResult = statment.executeQuery();
            if (contentResult.next()) {
                entrega.setCodigo(contentResult.getInt("codigo"));
                entrega.setCodigoPedido(contentResult.getInt("codigo_pedido"));
                entrega.setValor(contentResult.getDouble("valor"));
                entrega.setStatus(contentResult.getString("status"));
                entrega.setCriadoEm(contentResult.getString("criado_em"));
            } else {
                entrega = null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
            entrega = null;
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return entrega;
    }
    
    public List<Entrega> consultaTodos() {
        conectar();
        List<Entrega> entregas = new ArrayList<>();

        try {
            statment = conn.prepareStatement("SELECT * FROM entregas");
            contentResult = statment.executeQuery();
            while(contentResult.next()) {
                Entrega entrega = new Entrega();
                entrega.setCodigo(contentResult.getInt("codigo"));
                entrega.setCodigoPedido(contentResult.getInt("codigo_pedido"));
                entrega.setValor(contentResult.getDouble("valor"));
                entrega.setStatus(contentResult.getString("status"));
                entrega.setCriadoEm(contentResult.getString("criado_em"));
                
                entregas.add(entrega);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
            entregas = null;
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return entregas;
    }
    
    public boolean excluir(int codigo) {
        conectar();
        try {
            statment = conn.prepareStatement("DELETE FROM entregas WHERE codigo = ?");
            statment.setInt(1, codigo);
            statment.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            return false;
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }
    }
}
