/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author romulo
 */
public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf) {
        super(nome, cpf);
    }

    public void novoProduto() {
        String codigoProduto, nomeProduto, marcaProduto, categoriaProduto;
        double precoProduto;
        Produto novoProduto;
        JTextField codigo = new JTextField();
        JTextField nome = new JTextField();
        JTextField marca = new JTextField();
        JTextField categoria = new JTextField();
        JTextField preco = new JTextField();

        Object[] campos = {
            "COD.:", codigo,
            "NOME::", nome,
            "MARCA: ", marca,
            "CATEGORIA", categoria,
            "PREÇO: ", preco
        };
        
        int option = JOptionPane.showConfirmDialog(null, campos, "NOVO PRODUTO", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            //novoProduto = new ProdutoUnidade(codigoProduto, nomeProduto, marcaProduto, categoriaProduto, precoProduto)
        } 

    }

    public void atualizarEstoque(String cod) {

    }
}
