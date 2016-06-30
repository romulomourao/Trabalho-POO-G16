/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.OptionPaneUI;
import model.Funcionario;

/**
 *
 * @author romulo
 */
public class Tela {

    private JFrame janela;
    private JTabbedPane abas;
    private JPanel painelPrincipal, painelBotoes, painelSuperior, painelConsulta, painelVendas, painelControle;
    private String cpfUsuario, numeroCaixa;
    private PainelDeUsuario painelUsuario;

    public void inicializa() {
        preparaJanela();
        preparaPainelPrincipal();
        preparaPainelUsuario();
        adicionaAbas();
        adicionaPainelDeConsulta();
        adicionaPainelDeVenda();
        adicionaPainelDeControle();
        preparaPainelSair();
        mostraJanela();

    }

    private void preparaJanela() {
        janela = new JFrame("JAVA SUPERMERCADO");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void preparaPainelPrincipal() {
        painelPrincipal = new PainelInterno(new BorderLayout(), 50, 100);
        janela.add(painelPrincipal);
    }

    private void preparaPainelSair() {
        painelBotoes = new PainelInterno(new GridLayout(), false);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
        preparaBotaoSair();

    }

    private void preparaBotaoSair() {
        JButton botaoSair = new Botao("Sair", "#607D8B");

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        painelBotoes.add(botaoSair);
    }

    private void mostraJanela() {
        janela.pack();
        janela.setSize(1000, 800);
        janela.setVisible(true);
    }

    private void adicionaAbas() {
        abas = new PainelComAbas();
        painelPrincipal.add(abas);

    }

    private void preparaPainelUsuario() {
        // usuario();
       // painelSuperior = new PainelInterno();
//        painelPrincipal.add(painelSuperior, BorderLayout.NORTH);
//
       painelUsuario = new PainelDeUsuario(new BorderLayout(), true);
//        painelSuperior.add(painelUsuario);
       cpfUsuario = painelUsuario.getUsuario();
       numeroCaixa = painelUsuario.getCaixa();

    }

    private void adicionaPainelDeConsulta() {
        painelConsulta = new PainelDeConsulta();
        abas.setComponentAt(0, painelConsulta);
    }

    private void adicionaPainelDeVenda() {
        painelVendas = new PainelDeVendas(numeroCaixa, cpfUsuario, painelUsuario);
        abas.setComponentAt(1, painelVendas);
        /*
        painelVendas = new PainelDeVendas(numeroCaixa, cpfUsuario, painelUsuario.getHeader());
        JTextArea nomeCliente = new Texto("", 14, 10, 10, "#03A9F4");
        painelUsuario.add(nomeCliente, BorderLayout.PAGE_END);
        abas.setComponentAt(1, painelVendas);
        
        */
    }

    private void adicionaPainelDeControle() {
        painelControle = new PainelDeControle(new GridLayout(8, 0), 50, 20);
        abas.setComponentAt(2, painelControle);
    }

}
