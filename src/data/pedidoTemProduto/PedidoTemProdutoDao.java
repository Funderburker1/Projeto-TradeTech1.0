/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pedidoTemProduto;

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
public class PedidoTemProdutoDao extends Database {

    private PreparedStatement statment = getStatment();
    private Connection conn = getConn();
    private ResultSet contentResult;

    public int salvar(PedidoTemProduto relacao) {
        int status;

        try {
            statment = conn.prepareStatement("INSERT INTO pedido_tem_produto(codigo_pedido,codigo_produto,quantidade,valor) VALUES(?,?,?,?)");
            statment.setInt(1, relacao.getCodigoPedido());
            statment.setInt(2, relacao.getCodigoProduto());
            statment.setInt(3, relacao.getQuantidade());
            statment.setDouble(4, relacao.getValor());
            status = statment.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            status = ex.getErrorCode();
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return status;
    }

    public int salvar(List<PedidoTemProduto> relacoes) {

        int status = 0;
        for (int i = 0; i < relacoes.size(); i++) {
            PedidoTemProduto relacao = relacoes.get(i);
            
            status = salvar(relacao);
            
            if (status != 1) {
                break;
            }
        }

        return status;
    }

    public int updade(PedidoTemProduto relacao) {
        conectar();
        int status;

        try {
            statment = conn.prepareStatement("UPDATE pedido_tem_produto SET quantidade=? WHERE codigo_pedido = ? and codigo_produto = ?");
            statment.setInt(1, relacao.getQuantidade());
            statment.setInt(2, relacao.getCodigoPedido());
            statment.setInt(3, relacao.getCodigoProduto());
            status = statment.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            status = ex.getErrorCode();
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return status;
    }

    public Produto consulta(int codigoPedido, int codigoProduto) {
        conectar();
        Produto produto = new Produto();

        try {
            statment = conn.prepareStatement("SELECT * FROM pedido_tem_produto WHERE codigo_pedido = ? and codigo_produto = ?");
            statment.setInt(1, codigoPedido);
            statment.setInt(1, codigoProduto);
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
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return produto;
    }

    public List<PedidoTemProduto> consultaPedido(int codigoPedido) {
        conectar();
        List<PedidoTemProduto> relacoes = new ArrayList<>();

        try {
            statment = conn.prepareStatement("SELECT * FROM pedido_tem_produto where codigo_pedido = ?");
            statment.setInt(1, codigoPedido);
            contentResult = statment.executeQuery();

            while (contentResult.next()) {
                PedidoTemProduto relacao = new PedidoTemProduto();

                relacao.setCodigoProduto(contentResult.getInt("codigo_produto"));
                relacao.setCodigoPedido(contentResult.getInt("codigo_pedido"));
                relacao.setQuantidade(contentResult.getInt("quantidade"));
                relacao.setValor(contentResult.getDouble("valor"));

                relacoes.add(relacao);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return relacoes;
    }

    public boolean excluir(int codigoPedido, int codigoProduto) {
        conectar();
        try {
            statment = conn.prepareStatement("DELETE FROM pedido_tem_produto WHERE codigo_pedido = ? and codigo_produto = ?");
            statment.setInt(1, codigoPedido);
            statment.setInt(1, codigoProduto);
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
    
    public boolean excluir(int codigoPedido) {
        conectar();
        try {
            statment = conn.prepareStatement("DELETE FROM pedido_tem_produto WHERE codigo_pedido = ?");
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
