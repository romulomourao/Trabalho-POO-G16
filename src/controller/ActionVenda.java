/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import model.Estoque;
import model.ItemDeVenda;
import model.ItemDeVendaQuilo;
import model.ItemDeVendaUnidade;
import model.ItemEstoque;
import model.ItemEstoqueQuilo;
import model.ItemEstoqueUnidade;
import model.OperacaoNoBanco;
import model.Pagamento;
import model.PagamentoNoCartao;
import model.PagamentoNoDinheiro;
import model.Venda;
import view.CampoDeTexto;
import view.PainelDeUsuario;

/**
 *
 * @author romulo
 */
public class ActionVenda implements KeyListener, ActionListener {

    private final DefaultTableModel modeloTabela;
    private double totalDaVenda;
    private final JLabel labelTotal;
    private java.util.Map<String, ItemDeVenda> conjuntoDositens;
    private final PainelDeUsuario header;
    private final OperacaoNoBanco bancoDeDados;

    public ActionVenda(JLabel labelTotal, DefaultTableModel modeloTabela, PainelDeUsuario header) {
        this.modeloTabela = modeloTabela;
        this.totalDaVenda = 0.0;
        this.labelTotal = labelTotal;
        this.conjuntoDositens = new HashMap<>();
        this.header = header;
        this.bancoDeDados = OperacaoNoBanco.getInstance();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String codigo = ((CampoDeTexto) evt.getSource()).getText();
            if (!estaNaTabela(codigo)) {
                buscaEColocaNaTabela(codigo);

            }

            ((CampoDeTexto) evt.getSource()).setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private boolean estaNaTabela(String codigo) {
        boolean jaEsta = false;
        int quantidade;
        double preco;
        double subtotal;
        ItemDeVenda itemDeVenda;
        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            if (modeloTabela.getValueAt(i, 0).equals(codigo)) {
                itemDeVenda = conjuntoDositens.get(codigo);
                quantidade = (int) modeloTabela.getValueAt(i, 3);
                preco = itemDeVenda.getPreco();
                modeloTabela.setValueAt(++quantidade, i, 3);
                subtotal = itemDeVenda.subtotal(quantidade);
                totalDaVenda += preco;
                labelTotal.setText("TOTAL: R$ " + String.format("%.2f", totalDaVenda));
                modeloTabela.setValueAt(String.format("%.2f", subtotal), i, 4);

                jaEsta = true;
            }

        }
        return jaEsta;
    }

    private void buscaEColocaNaTabela(String codigo) {
        String nome;
        double preco, subtotal;
        int quantidadeComprada = 1;
        int quantidadeEmEstoque;

        ItemDeVenda itemComprado;
        ItemEstoque item;
        if (bancoDeDados.existeCodigo(codigo)) {
            item = bancoDeDados.consultaERetornaItemDeEstoque(codigo);

            if (item.getClass().equals(ItemEstoqueQuilo.class)) {
                itemComprado = new ItemDeVendaQuilo(item);
                String gramas = JOptionPane.showInputDialog("Quantidade em gramas: ");
                quantidadeComprada = Integer.parseInt(gramas);
                //Verifica quantidade disponivel no banco                              
                quantidadeEmEstoque = item.getQuantidade();
                if (!temDisponivel(quantidadeEmEstoque, quantidadeComprada)) {
                    gramas = JOptionPane.showInputDialog("Temos apenas " + quantidadeEmEstoque + " gramas em estoque, digite uma nova quantidade: ");
                    quantidadeComprada = Integer.parseInt(gramas);

                }
                itemComprado.setQuantidade(quantidadeComprada);
            } else {
                itemComprado = new ItemDeVendaUnidade(item);
            }
            conjuntoDositens.put(codigo, itemComprado);
            nome = item.getProduto().getNome();
            preco = itemComprado.getPreco();
            subtotal = itemComprado.subtotal(quantidadeComprada);
            totalDaVenda += subtotal;
            labelTotal.setText("TOTAL: R$ " + String.format("%.2f", totalDaVenda));
            modeloTabela.addRow(new Object[]{codigo, nome, preco, quantidadeComprada, subtotal});
        } else {
            JOptionPane.showMessageDialog(null, "Este código não consta em nosso estoque", "ALGO DEU ERRADO...", ERROR_MESSAGE);
        }

    }
    //Ações do painel de Vendas
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
            case "Cancelar Venda":
                zerarValores();
                header.zerarCliente();
                break;

            case "CPF NA NOTA":
                header.setarCliente();
                break;
            case "Finalizar Venda":
                salvaItensDaTabela();
                Pagamento pagamento = pagar();
                Venda venda = new Venda(header.getCaixa(), header.getUsuario(), header.getCliente(), totalDaVenda, conjuntoDositens, pagamento);
                bancoDeDados.atualizaQuantidade(conjuntoDositens);
                bancoDeDados.salvaVenda(venda);
                
                zerarValores();
                header.zerarCliente();
                break;
            default:

                break;
        }

    }

    private void zerarValores() {
        totalDaVenda = 0.0;
        modeloTabela.setRowCount(0);
        labelTotal.setText("TOTAL: ");
        conjuntoDositens = new HashMap<>();
    }

    private void salvaItensDaTabela() {

        ItemEstoque itemNoEstoque;
        ItemDeVenda itemVendido;
        int linhas = modeloTabela.getRowCount();
        String codigo;
        int quantidade;
        for (int i = 0; i < linhas; i++) {
            codigo = (String) modeloTabela.getValueAt(i, 0);
            quantidade = (int) modeloTabela.getValueAt(i, 3);
            itemNoEstoque = bancoDeDados.consultaERetornaItemDeEstoque(codigo);
            itemVendido = itemVendido(itemNoEstoque, quantidade);
            this.conjuntoDositens.put(codigo, itemVendido);
        }

    }

    private ItemDeVenda itemVendido(ItemEstoque itemNoEstoque, int quantidade) {
        ItemDeVenda novo;

        if (itemNoEstoque.getClass().equals(ItemEstoqueUnidade.class)) {
            novo = new ItemDeVendaUnidade(itemNoEstoque, quantidade);
            return novo;
        }

        novo = new ItemDeVendaQuilo(itemNoEstoque, quantidade);
        return novo;
    }

    private Pagamento pagar() {
        Pagamento pagamento;
        double recebido;
        int parcela;
        String inputRecebido;
        String[] formasDePagamento = {"DINHEIRO", "CARTÃO"};
        Integer[] parcelas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ImageIcon icone = new ImageIcon("img/notes.png");
        String escolha = (String) JOptionPane.showInputDialog(null, "FORMA DE PAGAMENTO", "JAVA SUPERMERCADO", JOptionPane.OK_OPTION, icone, formasDePagamento, formasDePagamento[0]);
        if (formasDePagamento == null) {
            pagar();
        }
        //Pagamento em dinheiro
        if (escolha.equals(formasDePagamento[0])) {
            inputRecebido = JOptionPane.showInputDialog(null, "VALOR RECEBIDO:", "PAGAMENTO EM DINHEIRO", JOptionPane.OK_OPTION);
            recebido = Double.parseDouble(inputRecebido);
            pagamento = new PagamentoNoDinheiro(totalDaVenda);
            pagamento.realizaOperacao(recebido);
            //Pagamento no cartão    
        } else {
            icone = new ImageIcon("img/card.png");
            parcela = (Integer) JOptionPane.showInputDialog(null, "PARCELAS:", "PAGAMENTO NO CARTÃO", JOptionPane.OK_OPTION, icone, parcelas, parcelas[0]);
            pagamento = new PagamentoNoCartao(totalDaVenda, parcela);
            pagamento.realizaOperacao(totalDaVenda);
        }

        return pagamento;
    }

    private boolean temDisponivel(int qtdEmEstoque, int qtdComprada) {
        return qtdEmEstoque >= qtdComprada;
    }

}
