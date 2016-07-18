/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ActionVenda;
import controller.EventoMudarFuncionarioECaixa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author romulo
 */
public class PainelDeVendas extends PainelInterno {

    private JButton botaoFinalizar, botaoCadastrarCliente, botaoCancelar, botaoAlterarFuncionario, botaoExcluirItem;
    private JPanel painelSideBar, painelSuperior;
    private PainelDeUsuario header;
    private ActionListener actionMudaFuncionario;
    private ActionVenda actionVenda;
    private JLabel labelTotal;
    private JTextField campoDeBusca;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private String numeroDoCaixa, cpfUsuario;
    
   

    public PainelDeVendas(String numeroDoCaixa, String cpfUsuario, PainelDeUsuario header) {
        super(new BorderLayout(5, 5), true);
        this.numeroDoCaixa = numeroDoCaixa;
        this.cpfUsuario = cpfUsuario;
        this.header = header;
 
        adicionaSideBar();
        barraDeTotal();
        tabelaDeVendas();
        criaPainelSUperior();
        barraDeBusca();
        botaoCancelar();
        botaoFinalizar();
        botaoCadastrarCliente();
        botaoAlterarFuncionario();
    }

    private void botaoAlterarFuncionario() {
        botaoAlterarFuncionario = new Botao("Alterar Caixa");
        actionMudaFuncionario = new EventoMudarFuncionarioECaixa(header, painelSuperior);
        botaoAlterarFuncionario.addActionListener(actionMudaFuncionario);
        painelSideBar.add(botaoAlterarFuncionario);
    }

    private void botaoCadastrarCliente() {
        botaoCadastrarCliente = new Botao("CPF NA NOTA");
        botaoCadastrarCliente.addActionListener(actionVenda);
        painelSideBar.add(botaoCadastrarCliente);
    }

    private void botaoCancelar() {
        botaoCancelar = new Botao("Cancelar Venda");       
        botaoCancelar.addActionListener(actionVenda);
        painelSideBar.add(botaoCancelar);
    }


    private void botaoFinalizar() {

        botaoFinalizar = new Botao("Finalizar Venda");
        botaoFinalizar.addActionListener(actionVenda);
        painelSideBar.add(botaoFinalizar);

    }

    private void barraDeTotal() {
        labelTotal = new Label("TOTAL:", SwingConstants.LEFT, 50);
        this.add(labelTotal, BorderLayout.PAGE_END);

    }

    private void barraDeBusca() {
        //Barra de Busca
        campoDeBusca = new CampoDeTexto("","#009688");
        actionVenda = new ActionVenda(labelTotal, modeloTabela, header);
        campoDeBusca.addKeyListener(actionVenda);
        // this.add(campoDeBusca, BorderLayout.BEFORE_FIRST_LINE);
        //teste        
        painelSuperior.add(campoDeBusca);
    }

    private void tabelaDeVendas() {
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Cod.");
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Preço (R$)");
        modeloTabela.addColumn("Quantidade");
        modeloTabela.addColumn("Subtotal(R$)");
        modeloTabela.addTableModelListener(tabela);
        tabela = new Tabela(modeloTabela);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(tabela);
        scroll.getViewport().setBackground(Color.decode("#607D8B"));
        this.add(scroll, BorderLayout.CENTER);

    }

    private void adicionaSideBar() {
        painelSideBar = new PainelInterno(new GridLayout(6, 0), false);
        this.add(painelSideBar, BorderLayout.LINE_END);
    }

    private void criaPainelSUperior() {
        painelSuperior = new PainelInterno(new GridLayout(2, 0), 10, 10);
        this.add(painelSuperior, BorderLayout.BEFORE_FIRST_LINE);
        painelSuperior.add(header);
    }

}
