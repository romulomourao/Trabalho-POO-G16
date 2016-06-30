/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import view.TelaDeLogin;

/**
 *
 * @author romulo
 */
public class ActionsPainelDeControle implements ComponentListener, ActionListener {

    private JButton salvarTudo, atualizarEstoque, cadastrarProdutos, relatorio;

    public ActionsPainelDeControle(JButton salvarTudo, JButton atualizarEstoque, JButton cadastrarProdutos, JButton relatorio) {
        this.salvarTudo = salvarTudo;
        this.atualizarEstoque = atualizarEstoque;
        this.cadastrarProdutos = cadastrarProdutos;
        this.relatorio = relatorio;
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {       
        final JFrame frame = new JFrame();
        TelaDeLogin telaLogin = new TelaDeLogin(frame);
        telaLogin.setVisible(true);
        if (telaLogin.isSucceeded()) {
            salvarTudo.setVisible(true);
            relatorio.setVisible(true);
            cadastrarProdutos.setVisible(true);
            atualizarEstoque.setVisible(true);
        }

    }

    @Override
    public void componentHidden(ComponentEvent e) {
       
        salvarTudo.setVisible(false);
        relatorio.setVisible(false);
        cadastrarProdutos.setVisible(false);
        atualizarEstoque.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
