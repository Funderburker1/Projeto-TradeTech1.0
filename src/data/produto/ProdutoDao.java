/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.produto;

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
public class ProdutoDao extends Database {

    private PreparedStatement statment = getStatment();
    private Connection conn = getConn();
    private ResultSet contentResult;

    public int salvar(Produto produto) {
        conectar();
        int status;

        try {
            statment = conn.prepareStatement("INSERT INTO produtos(nome,quantidade,valor) VALUES(?,?,?)");
            statment.setString(1, produto.getNome());
            statment.setInt(2, produto.getQuantidade());
            statment.setDouble(3, produto.getValor());
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

    public int updade(Produto produto) {
        conectar();
        int status;

        try {
            statment = conn.prepareStatement("UPDATE produtos SET nome=?,quantidade=?,valor=? WHERE codigo_produto = ?");
            statment.setString(1, produto.getNome());
            statment.setInt(2, produto.getQuantidade());
            statment.setDouble(3, produto.getValor());
            statment.setInt(4, produto.getCodigo());
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
    
    public int updadeEstoque(int codigo, int novaQuantidade) {
        conectar();
        int status;

        try {
            statment = conn.prepareStatement("UPDATE produtos SET quantidade=? WHERE codigo_produto = ?");
            statment.setInt(1, novaQuantidade);
            statment.setInt(2, codigo);
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
            statment = conn.prepareStatement("SELECT * FROM sqlite_sequence where name='produtos'");
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

    public Produto consulta(String codigo) {
        conectar();
        Produto produto = new Produto();

        try {
            statment = conn.prepareStatement("SELECT * FROM produtos WHERE codigo_produto = ?");
            statment.setString(1, codigo);
            contentResult = statment.executeQuery();
            if (contentResult.next()) {
                produto.setCodigo(contentResult.getInt("codigo_produto"));
                produto.setNome(contentResult.getString("nome"));
                produto.setQuantidade(contentResult.getInt("quantidade"));
                produto.setValor(contentResult.getDouble("valor"));
            } else {
                produto = null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
            produto = null;
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return produto;
    }

    public List<Produto> consultaTodos() {
        conectar();
        List<Produto> produtos = new ArrayList<>();

        try {
            statment = conn.prepareStatement("SELECT * FROM produtos");
            contentResult = statment.executeQuery();

            while (contentResult.next()) {
                Produto produto = new Produto();

                produto.setCodigo(contentResult.getInt("codigo_produto"));
                produto.setNome(contentResult.getString("nome"));
                produto.setQuantidade(contentResult.getInt("quantidade"));
                produto.setValor(contentResult.getDouble("valor"));

                produtos.add(produto);
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

        return produtos;
    }

    public boolean excluir(int codigo) {
        conectar();
        try {
            statment = conn.prepareStatement("DELETE FROM produtos WHERE codigo_produto = ?");
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
