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
public class ProdutoQuilo extends Produto {

    public ProdutoQuilo(String codigo, String nome, String marca, String categoria,double preco) {
        super(codigo,nome,marca,categoria,preco,false);
    }


}
