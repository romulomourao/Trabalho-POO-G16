/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.OperacaoNoBanco;

/**
 *
 * @author romulo
 */
public class EventoBotaoSalvarNovoProdutoQuilo implements ActionListener {

    private final JTextField campoCodigo;
    private final JTextField campoNome;
    private final JTextField campoMarca;
    private final JTextField campoCategoria;
    private final JFormattedTextField campoPreco;
    private final JFormattedTextField campoQuantidade;
    private final JFrame janela;

    public EventoBotaoSalvarNovoProdutoQuilo(JFrame janela, JTextField campoCodigo, JTextField campoNome, JTextField campoMarca, JTextField campoCategoria, JFormattedTextField campoPreco, JFormattedTextField campoQuantidade) {
        this.campoCodigo = campoCodigo;
        this.campoNome = campoNome;
        this.campoMarca = campoMarca;
        this.campoCategoria = campoCategoria;
        this.campoPreco = campoPreco;
        this.campoQuantidade = campoQuantidade;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cod, nome, marca, categoria;
        cod = campoCodigo.getText();
        nome = campoNome.getText();
        marca = campoMarca.getText();
        categoria = campoCategoria.getText();
        String respPreco = campoPreco.getText();
        String respQtd = campoQuantidade.getText();

        if (cod.equals("") || nome.equals("") || marca.equals("") || categoria.equals("") || respQtd.equals("") || respPreco.equals("")) {
            JOptionPane.showMessageDialog(janela, "POR FAVOR, PREENCHA TODOS OS CAMPOS");
        } else {
            respPreco = respPreco.replace(",", ".");
            double preco = Double.parseDouble(respPreco);
            int quantidade = Integer.parseInt(respQtd);           
            new OperacaoNoBanco().insereNovoProduto(cod, nome.toUpperCase(), marca.toUpperCase(), categoria.toUpperCase(), preco, quantidade, false);
            janela.dispose();

        }

    }


}
