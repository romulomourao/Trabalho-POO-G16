/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import model.ItemEstoque;

/**
 *
 * @author romulo
 */
public class ProdutosModeloTabela extends AbstractTableModel {

    private final java.util.Map<String, ItemEstoque> produtos;
    private java.util.List<ItemEstoque> itens;

    public ProdutosModeloTabela(Map<String, ItemEstoque> produtos) {
        this.produtos = produtos;
        itens = new ArrayList<>();
        for (String cod : this.produtos.keySet()) {
            itens.add(this.produtos.get(cod));
        }
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ItemEstoque p = itens.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getProduto().getCodigo();
            case 1:
                return p.getProduto().getNome();
            case 2:
                return p.getProduto().getMarca();
            case 3:
                return p.getProduto().getCategoria();
            case 4:
                return p.getProduto().getPreco();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
      switch (column) {
            case 0:
                return "Codigo";
            case 1:
                return "Nome";
            case 2:
                return "Marca";
            case 3:
                return "Categoria";
            case 4:
                return "Preço";
        }
        return "";
    }

}
