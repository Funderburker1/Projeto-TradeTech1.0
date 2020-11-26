/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pedido;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro
 */
public class PedidoTableModel extends AbstractTableModel {
    private List<Pedido> dados = new ArrayList<>();
    private String[] colunas = {"Codigo Pedido", "Data/Hora","Valor","Status"};
    private double valorTotal = 0;

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
        switch (coluna) {
            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getCriadoEm();
            case 2:
                return dados.get(linha).getValor();
            case 3:
                return dados.get(linha).getStatus();
            default:
                return null;
        }
    }

    public List<Pedido> getDados() {
        return dados;
    }

    public boolean adicionaLinha(Pedido itemPedido) {
        boolean status = true;
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getCodigo() == itemPedido.getCodigo()) {
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

    public void adicionaVariasLinhas(List<Pedido> clientes) {
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
            if (dados.get(i).getCodigo() == codigo) {
                dados.remove(i);
                this.fireTableDataChanged();
            }
        }
    }

    public Pedido consulta(int codigoPedido) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getCodigo() == codigoPedido) {
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
