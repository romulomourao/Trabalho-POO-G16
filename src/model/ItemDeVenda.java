package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romulo
 */
public abstract class ItemDeVenda {
    private final String codigo;
    private int quantidade;
    private final double preco;
    private String sufixo;

    public void setSufixo(String sufixo) {
        this.sufixo = sufixo;
    }

    
    public ItemDeVenda(ItemEstoque item, int quantidade) {
        this.codigo = item.getProduto().getCodigo();
        this.quantidade = quantidade;
        this.preco = item.getProduto().getPreco();
    }
    
     public ItemDeVenda(ItemEstoque item) {
        this.codigo = item.getProduto().getCodigo();       
        this.preco = item.getProduto().getPreco();
    }
    
    public abstract String quantidadeComSufixo();
    
    public abstract double subtotal(int quantidade);

  

    public int getQuantidade() {
        return quantidade;
    }

    public String getCodigo() {
        return codigo;
    }
    

    public double getPreco() {
        return preco;
    }

    public String getSufixo() {
        return sufixo;
    }
    

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
