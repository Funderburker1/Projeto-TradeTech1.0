/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.produto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro
 */
public class ProdutoTableModel extends AbstractTableModel{

    private List<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Codigo","Produto","Quantidade","Valor"};
    
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
        switch(coluna){
            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getQuantidade();
            case 3:
                return dados.get(linha).getValor();
            default:
                return null;
        }
    }
    
    public void adicionaVariasLinhas(List<Produto> clientes){
        for (int i = 0; i < clientes.size(); i++) {
            this.dados.add(clientes.get(i));
        }
        this.fireTableDataChanged();
    }
    
    public void limpaTabela(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
}
