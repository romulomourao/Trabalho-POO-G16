/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.ItemEstoque;
import model.OperacaoNoBanco;
import model.Produto;

/**
 *
 * @author romulo
 */
public class EventoConsultarProduto implements KeyListener {

    private String cod;
    private String encontrado;
    private final JTextArea label;
    private final JTextField campoDeTexto;
    private Produto produto;

    public EventoConsultarProduto(JTextArea produtoEncontrado, JTextField campoDeTexto) {
        this.label = produtoEncontrado;
        this.campoDeTexto = campoDeTexto;
    }


    private void consultaPeloCodigo(String cod) {
        ItemEstoque item = new OperacaoNoBanco().consultaERetornaItemDeEstoque(cod);
        encontrado = item.getProduto().getNome() +"\nR$ "+item.getProduto().getPreco();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.cod = campoDeTexto.getText();
            if (!cod.equals("")) {
                consultaPeloCodigo(cod);
                this.label.setText(encontrado);
                this.campoDeTexto.setText("");
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
