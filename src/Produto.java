/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romul
 */
public class Produto {
    private String nome;
    private String descricao;
    private boolean vendidoPorPeso;
    private String codBarras;
    private double preco;
    private double qtdEstoque;

    public Produto(String nome, String descricao, boolean vendidoPorPeso, String codBarras, double preco, double qtdEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.vendidoPorPeso = vendidoPorPeso;
        this.codBarras = codBarras;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isVendidoPorPeso() {
        return vendidoPorPeso;
    }

    public void setVendidoPorPeso(boolean vendidoPorPeso) {
        this.vendidoPorPeso = vendidoPorPeso;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
     
}
