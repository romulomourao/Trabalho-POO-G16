/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControleEstoqueAtualizarBanco;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author romulo
 */
public class JanelaAtualizaEstoque extends JFrame {

    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JTextField campoQuantidade;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JLabel labelSufixo;
    private javax.swing.JLabel tituloProduto;
    private final String codigo;
    private final String produto;
    private final int quantidade;
    private final String sufixo;

    public JanelaAtualizaEstoque(String produto, String codigo, int quantidade, String sufixo) {
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
        this.sufixo = sufixo;
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        botaoAtualizar = new Botao();
        tituloProduto = new Label(20);
        labelQuantidade = new Label(16);
        labelSufixo = new Label(14);
        String qtd = "" + quantidade;
        campoQuantidade = new CampoDeTexto(qtd, 18);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tituloProduto.setText(produto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        getContentPane().add(tituloProduto, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        getContentPane().add(campoQuantidade, gridBagConstraints);

        labelQuantidade.setText("QUANTIDADE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        getContentPane().add(labelQuantidade, gridBagConstraints);

        labelSufixo.setText(sufixo);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(labelSufixo, gridBagConstraints);
        getContentPane().setBackground(Color.decode("#455A64"));

        botaoAtualizar.setText("ATUALIZAR");
        ControleEstoqueAtualizarBanco actionAtualizarBanco = new ControleEstoqueAtualizarBanco(campoQuantidade, codigo, sufixo);
        botaoAtualizar.addActionListener(actionAtualizarBanco);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 18, 18);
        getContentPane().add(botaoAtualizar, gridBagConstraints);

        this.setSize(500, 300);
        this.setTitle("ATUALIZAR QUANTIDADE");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

    }

}
