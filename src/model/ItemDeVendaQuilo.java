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
public class ItemDeVendaQuilo extends ItemDeVenda {

    public ItemDeVendaQuilo(ItemEstoque item, int quantidade) {
        super(item, quantidade);
        sufixo();
    }

    public ItemDeVendaQuilo(ItemEstoque item) {
        super(item);
        sufixo();
    }
    
    
    @Override
    public String quantidadeComSufixo() {
        String resp;
        int qtd = this.getQuantidade();
        double quilos = (qtd / 1000.0);
        resp = quilos +" "+ this.getSufixo();
        return resp;
    }

    private void sufixo() {
        this.setSufixo("Kg");
    }

    @Override
    public double subtotal(int quantidade) {
        double valor = (quantidade * this.getPreco()) / 1000;
        return valor;
    }

}
