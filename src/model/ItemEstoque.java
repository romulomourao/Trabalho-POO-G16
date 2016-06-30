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
public abstract class ItemEstoque {
    private final Produto produto;
    private int quantidade;
    

    public ItemEstoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        
    }

    
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void atualizaQuantidade(int QtdVendida){
        this.quantidade -= QtdVendida; 
    }
    
    public Produto getProduto(){
        return this.produto;
    }
       
}
