/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pedido;

import data.Database;
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
public class PedidoDao extends Database{

    private PreparedStatement statment = getStatment();
    private Connection conn = getConn();
    private ResultSet contentResult;
    
    public int salvar(Pedido pedido) {
        int status;

        try {
            System.out.println("data.pedido.PedidoDao.salvar()");
            statment = conn.prepareStatement("INSERT INTO pedidos(entrega,cep,numero,cidade,logradouro,codigo,bairro,valor,telefone) VALUES(?,?,?,?,?,?,?,?,?)");
            statment.setString(1, pedido.getEntrega());
            statment.setString(2, pedido.getCep());
            statment.setInt(3, pedido.getNumero());
            statment.setString(4, pedido.getCidade());
            statment.setString(5, pedido.getLogradouro());
            statment.setInt(6, pedido.getCodigoCliente());
            statment.setString(7, pedido.getBairro());
            statment.setDouble(8, pedido.getValor());
            statment.setString(9, pedido.getTelefone());
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
    
    public int updade(Pedido pedido) {
        int status;

        try {
            statment = conn.prepareStatement("UPDATE pedidos SET entrega=?,cep=?,numero=?,cidade=?,logradouro=?,codigo=?,bairro=?,valor=? WHERE codigo_pedido = ?");
            statment.setString(1, pedido.getEntrega());
            statment.setString(2, pedido.getCep());
            statment.setInt(3, pedido.getNumero());
            statment.setString(4, pedido.getCidade());
            statment.setString(5, pedido.getLogradouro());
            statment.setInt(6, pedido.getCodigoCliente());
            statment.setString(7, pedido.getBairro());
            statment.setDouble(8, pedido.getValor());
            statment.setInt(9, pedido.getCodigo());
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
    
    public int updade(int codigo, String status) {
        int feedback;

        try {
            statment = conn.prepareStatement("UPDATE pedidos SET status=? WHERE codigo_pedido = ?");
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

    public int consultaProximoCodigo() {
        int codigo = 0;
        try {
            statment = conn.prepareStatement("SELECT * FROM sqlite_sequence where name='pedidos'");
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

    public Pedido consulta(String codigo) {
        Pedido pedido = new Pedido();

        try {
            statment = conn.prepareStatement("SELECT * FROM pedidos WHERE codigo_pedido = ?");
            statment.setString(1, codigo);
            contentResult = statment.executeQuery();
            if (contentResult.next()) {
                pedido.setCodigo(contentResult.getInt("codigo_pedido"));
                pedido.setEntrega(contentResult.getString("entrega"));
                pedido.setCep(contentResult.getString("entrega"));
                pedido.setNumero(contentResult.getInt("numero"));
                pedido.setCidade(contentResult.getString("cidade"));
                pedido.setLogradouro(contentResult.getString("logradouro"));
                pedido.setTelefone(contentResult.getString("telefone"));
                pedido.setBairro(contentResult.getString("bairro"));
                pedido.setCodigoCliente(contentResult.getInt("codigo"));
                pedido.setValor(contentResult.getDouble("valor"));
            } else {
                pedido = null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
            pedido = null;
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return pedido;
    }

    public List<Pedido> consultaTodos() {
        List<Pedido> pedidos = new ArrayList<>();

        try {
            statment = conn.prepareStatement("SELECT * FROM pedidos");
            contentResult = statment.executeQuery();

            while (contentResult.next()) {
                Pedido pedido = new Pedido();

                pedido.setCodigo(contentResult.getInt("codigo_pedido"));
                pedido.setEntrega(contentResult.getString("entrega"));
                pedido.setCep(contentResult.getString("entrega"));
                pedido.setNumero(contentResult.getInt("numero"));
                pedido.setCidade(contentResult.getString("cidade"));
                pedido.setLogradouro(contentResult.getString("logradouro"));
                pedido.setTelefone(contentResult.getString("telefone"));
                pedido.setBairro(contentResult.getString("bairro"));
                pedido.setCodigoCliente(contentResult.getInt("codigo"));
                pedido.setValor(contentResult.getDouble("valor"));
                pedido.setStatus(contentResult.getString("status"));
                pedido.setCriadoEm(contentResult.getString("criado_em"));

                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return pedidos;
    }
    
    public boolean excluir(int codigoPedido) {
        try {
            statment = conn.prepareStatement("DELETE FROM pedidos WHERE codigo_pedido = ?");
            statment.setInt(1, codigoPedido);
            statment.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            return false;
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }
    }
}
