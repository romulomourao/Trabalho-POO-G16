/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author romulo
 */
public class Estoque {

    private java.util.Map<String, ItemEstoque> estoque;
    private String nomeDoEstoque;

    public Estoque(String nomeDoEstoque) {
        this.estoque = new HashMap<>();
        this.nomeDoEstoque = nomeDoEstoque;
        carregaEstoque();

    }

    public void adicionaItemNoEstoque(String codigoDeBarras, ItemEstoque item) {
        this.estoque.put(codigoDeBarras, item);
    }

    public Map<String, ItemEstoque> acessa() {
        return estoque;
    }

    public void carregaEstoqueDoBanco() {
        Gson gson = new Gson();
    }

    public void carregaEstoque() {
        //le do arquivo e preenche o map

        Gson gson = new Gson();

        try {
            String js;

            BufferedReader br = new BufferedReader(new FileReader("unidade.json"));
            while ((js = br.readLine()) != null) {
                ProdutoUnidade produtoUnidade = gson.fromJson(js, ProdutoUnidade.class);
                ItemEstoque item = new ItemEstoqueUnidade(produtoUnidade, 100);
                adicionaItemNoEstoque(produtoUnidade.getCodigo(), item);
            }
            br.close();
            //convert the json string back to object  

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String js;

            BufferedReader br = new BufferedReader(new FileReader("quilo.json"));
            while ((js = br.readLine()) != null) {
                ProdutoQuilo produtoQuilo = gson.fromJson(js, ProdutoQuilo.class);
                System.out.println(produtoQuilo.getCodigo());
                ItemEstoque item = new ItemEstoqueQuilo(produtoQuilo, 100);
                adicionaItemNoEstoque(produtoQuilo.getCodigo(), item);
            }
            br.close();
            //convert the json string back to object  

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
