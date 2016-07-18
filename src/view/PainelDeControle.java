/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ActionsPainelDeControle;
import controller.ControleEstoqueJanelas;
import controller.EventoBotaoInventario;
import controller.EventoBotaoRelatorio;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author romulo
 */
public class PainelDeControle extends PainelInterno{
    
    private JButton inventario, atualizarEstoque,cadastrarProdutoUnidade, relatorio,cadastrarProdutoQuilo;


    public PainelDeControle(LayoutManager layout, int vertical, int horizontal) {
        super(layout, vertical, horizontal);
        criaElementos();
        autenticacao();
    }


    
    private void autenticacao(){
            ActionsPainelDeControle actionGerente = new ActionsPainelDeControle(inventario, atualizarEstoque,cadastrarProdutoUnidade, relatorio);
           // this.addComponentListener(actionGerente);                      
    }

    private void criaElementos() {
        //Botão Atualizar Estoque
        atualizarEstoque = new Botao("Atualizar Estoque");
        ControleEstoqueJanelas actionControleEstoque = new ControleEstoqueJanelas();
        atualizarEstoque.addActionListener(actionControleEstoque);
        //Botão Cadastrar Novo Produtos
        cadastrarProdutoUnidade = new Botao("Cadastrar Produto Unitário");
        cadastrarProdutoUnidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janelaCadastro = new JanelaCadastroProdutoUnitario();
            }
        });
        
        cadastrarProdutoQuilo = new Botao("Cadastrar Produto a Quilo");
        cadastrarProdutoQuilo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janelaCadastro = new JanelaCadastroProdutoQuilo();
            }
        });
        //Botão GerarRelatorio
        relatorio = new Botao("Relatório");
        EventoBotaoRelatorio actionRelatorio = new EventoBotaoRelatorio();
        relatorio.addActionListener(actionRelatorio);
        //Botão Inventario
        inventario = new Botao("Inventário");
        EventoBotaoInventario actionInventario = new EventoBotaoInventario();
        inventario.addActionListener(actionInventario);
    
        this.add(inventario, SwingConstants.CENTER);
        this.add(relatorio, SwingConstants.CENTER);
        this.add(atualizarEstoque, SwingConstants.CENTER);
        this.add(cadastrarProdutoUnidade, SwingConstants.CENTER);
        this.add(cadastrarProdutoQuilo, SwingConstants.CENTER);

    }
}
