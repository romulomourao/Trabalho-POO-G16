/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.OperacaoNoBanco;

/**
 *
 * @author romulo
 */
public class ControleEstoqueAtualizarBanco implements ActionListener {

    private final JTextField campoQuantidade;
    private final String codigo;
    private final String sufixo;
    private int quantidade;

    public ControleEstoqueAtualizarBanco(JTextField campoQuantidade, String codigo, String sufixo) {
        this.campoQuantidade = campoQuantidade;
        this.codigo = codigo;
        this.sufixo = sufixo;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = campoQuantidade.getText();
        try {

            if (sufixo.equals("kg")) {

                double textoParaDouble = Double.parseDouble(texto);
                quantidade = (int) (textoParaDouble * 1000);

            } else {
                quantidade = Integer.parseInt(texto);
            }
            new OperacaoNoBanco().atualizaQuantidade(codigo, quantidade);
        } catch (Exception evt) {
            JOptionPane.showMessageDialog(null, "QUANTIDADE INVÁLIDA!");
            campoQuantidade.setText("");
        }

    }

}
