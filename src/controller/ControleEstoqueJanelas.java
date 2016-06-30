/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ItemEstoque;
import model.OperacaoNoBanco;
import view.JanelaAtualizaEstoque;

/**
 *
 * @author romulo
 */
public class ControleEstoqueJanelas implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame janela;
        String codigo = JOptionPane.showInputDialog("CÓDIGO DO PRODUTO: ");
        ItemEstoque item = new OperacaoNoBanco().consultaERetornaItemDeEstoque(codigo);
        int quantidadeEmEstoque = item.getQuantidade();
        String nome = item.getProduto().getNome();
        if (item.getProduto().isUnitario()) {
            janela = new JanelaAtualizaEstoque(nome, codigo, quantidadeEmEstoque,"unidades");
        } else {
            janela = new JanelaAtualizaEstoque(nome, codigo, quantidadeEmEstoque,"kg");
        }
    }

}
