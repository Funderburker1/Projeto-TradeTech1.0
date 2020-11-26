/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pedidoTemProduto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro
 */
public class PedidoTemProdutoTableModel extends AbstractTableModel {

    private List<PedidoTemProduto> dados = new ArrayList<>();
    private String[] colunas = {"Codigo", "Produto", "Qtd Estoque", "Quantidade", "Valor"};
    private double valorTotal = 0;

    public PedidoTemProdutoTableModel(String[] colunas) {
        this.colunas = colunas;
    }

    public PedidoTemProdutoTableModel() {
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        if (colunas.length == 5) {
            switch (coluna) {
                case 0:
                    return dados.get(linha).getCodigoProduto();
                case 1:
                    return dados.get(linha).getProduto();
                case 2:
                    return dados.get(linha).getQuantidadeEstoque();
                case 3:
                    return dados.get(linha).getQuantidade();
                case 4:
                    return dados.get(linha).getValor();
                default:
                    return null;
            }
        } else {
            switch (coluna) {
                case 0:
                    return dados.get(linha).getCodigoProduto();
                case 1:
                    return dados.get(linha).getProduto();
                case 2:
                    return dados.get(linha).getQuantidade();
                case 3:
                    return dados.get(linha).getValor();
                default:
                    return null;
            }
        }
    }

    public List<PedidoTemProduto> getDados() {
        return dados;
    }

    public boolean adicionaLinha(PedidoTemProduto itemPedido) {
        boolean status = true;
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getCodigoProduto() == itemPedido.getCodigoProduto()) {
                status = false;
            }
        }
        if (status) {
            this.dados.add(itemPedido);
            this.fireTableDataChanged();
            return true;
        }
        return false;
    }

    public void adicionaVariasLinhas(List<PedidoTemProduto> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            this.dados.add(clientes.get(i));
        }
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        this.dados.clear();
        this.fireTableDataChanged();
    }

    public void removerProduto(int codigo) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getCodigoProduto() == codigo) {
                dados.remove(i);
                this.fireTableDataChanged();
            }
        }
    }

    public void alterarProduto(int codigo, int quantidade,int estoque, double valor) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getCodigoProduto() == codigo) {
                PedidoTemProduto produtoDoPedido = dados.get(i);
                produtoDoPedido.setQuantidade(quantidade);
                produtoDoPedido.setQuantidadeEstoque(estoque);
                produtoDoPedido.setValor(valor);
                dados.set(i, produtoDoPedido);
                this.fireTableDataChanged();
            }
        }
    }

    public PedidoTemProduto consulta(int codigoProduto) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getCodigoProduto() == codigoProduto) {
                return dados.get(i);
            }
        }
        return null;
    }

    public double getValorTotal() {
        valorTotal = 0;
        for (int i = 0; i < dados.size(); i++) {
            valorTotal += dados.get(i).getValor();
        }
        return valorTotal;
    }
}
