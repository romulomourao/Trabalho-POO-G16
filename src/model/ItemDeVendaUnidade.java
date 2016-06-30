/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author romulo
 */
public class ItemDeVendaUnidade extends ItemDeVenda {

    public ItemDeVendaUnidade(ItemEstoque item, int quantidade) {
        super(item, quantidade);
        sufixo();
    }

    public ItemDeVendaUnidade(ItemEstoque item) {
        super(item);
        sufixo();
    }

    
    private void sufixo() {
        this.setSufixo("unidade(s)");
    }

    @Override
    public String quantidadeComSufixo() {
        String resp;
        int qtd = this.getQuantidade();        
        resp = qtd +" "+ this.getSufixo();
        return resp;
    }

    @Override
    public double subtotal(int quantidade) {
        double valor = quantidade*this.getPreco();
        return valor;
    }

}
