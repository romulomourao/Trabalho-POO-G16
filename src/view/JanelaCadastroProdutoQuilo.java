/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EventoBotaoSalvarNovoProdutoQuilo;
import controller.EventoBotaoSalvarNovoProdutoUnitario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author romulo
 */
public class JanelaCadastroProdutoQuilo extends JFrame {
    
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoMarca;
    private javax.swing.JTextField campoCategoria;
    private JFormattedTextField campoQuantidade;
    private JFormattedTextField campoPreco;

    public JanelaCadastroProdutoQuilo() {
        initComponents();
    }

   private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelCodigo = new Label(20);
        labelNome = new Label(20);
        labelMarca = new Label(20);
        labelPreco = new Label(20);
        labelQuantidade = new Label(20);
        labelCategoria = new Label(20);
        campoCodigo = new CampoDeTexto(50);
        campoNome = new CampoDeTexto(50);
        campoMarca = new CampoDeTexto(50);
        campoCategoria = new CampoDeTexto(50);
        titulo = new Label(30);
        botaoSalvar = new Botao(10);

        formatoParaPreco();
        formatoParaQuantidade();
        //NumberFormat longFormat = NumberFormat.getIntegerInstance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[]{0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0, 11, 0};
        layout.rowHeights = new int[]{0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        labelCodigo.setText("CODIGO: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(16, 15, 17, 17);
        getContentPane().add(labelCodigo, gridBagConstraints);

        labelNome.setText("NOME:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 17, 14, 22);
        getContentPane().add(labelNome, gridBagConstraints);

        labelMarca.setText("MARCA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 15, 14, 17);
        getContentPane().add(labelMarca, gridBagConstraints);

        labelPreco.setText("PREÇO:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 15, 14, 17);
        getContentPane().add(labelPreco, gridBagConstraints);

        labelCategoria.setText("CATEGORIA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 15, 15, 17);
        getContentPane().add(labelCategoria, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(5, 7, 6, 9);
        getContentPane().add(campoCodigo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(5, 7, 6, 9);
        getContentPane().add(campoNome, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(5, 7, 6, 9);
        getContentPane().add(campoMarca, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(5, 7, 6, 9);
        getContentPane().add(campoCategoria, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(5, 7, 6, 9);
        getContentPane().add(campoPreco, gridBagConstraints);

        labelQuantidade.setText("QUANTIDADE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 15, 14, 17);
        getContentPane().add(labelQuantidade, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(5, 7, 6, 9);
        getContentPane().add(campoQuantidade, gridBagConstraints);

        titulo.setText("NOVO PRODUTO UNITÁRIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(18, 11, 19, 11);
        getContentPane().add(titulo, gridBagConstraints);

        botaoSalvar.setText("SALVAR");
        EventoBotaoSalvarNovoProdutoQuilo evento = new EventoBotaoSalvarNovoProdutoQuilo(this,campoCodigo, campoNome, campoMarca, campoCategoria, campoPreco, campoQuantidade);
        botaoSalvar.addActionListener(evento);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 12, 11);
        getContentPane().add(botaoSalvar, gridBagConstraints);
        getContentPane().setBackground(Color.decode("#455A64"));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    private void formatoParaPreco() {
        NumberFormat longFormat = new DecimalFormat("0.00");
        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Double.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0.00);
        numberFormatter.setOverwriteMode(true);
        numberFormatter.setCommitsOnValidEdit(true);

        campoPreco = new CampoFormatado(numberFormatter);

    }

    private void formatoParaQuantidade() {
        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0);
        numberFormatter.setOverwriteMode(true);
        numberFormatter.setCommitsOnValidEdit(true);
        campoQuantidade = new CampoFormatado(numberFormatter);
    }
}
