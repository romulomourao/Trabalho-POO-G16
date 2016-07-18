/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mongodb.Block;
import java.util.HashSet;
import java.util.Set;
import org.bson.Document;

/**
 *
 * @author romulo
 */
public class Inventario implements Block<Document> {
    private java.util.Set<ItemEstoque> inventario;

    public Inventario() {
        this.inventario = new HashSet<>();
    }

    @Override
    public void apply(Document document) {
        String codigo, nome, marca, categoria;
        double preco;
        int quantidade;
        boolean unitario;
        ItemEstoque item;
        Document produto = (Document) document.get("produto");
        codigo = produto.getString("codigo"); 
        nome = produto.getString("nome"); 
        marca = produto.getString("marca"); 
        categoria = produto.getString("categoria"); 
        unitario = produto.getBoolean("unitario");   
        preco = produto.getDouble("preco"); 
        quantidade = document.getInteger("quantidade");
        if(unitario){
            Produto p = new ProdutoUnidade(codigo, nome, marca, categoria, preco);
            item = new ItemEstoqueUnidade(p, quantidade);
        }else{
            Produto p = new ProdutoQuilo(codigo, nome, marca, categoria, preco);
            item = new ItemEstoqueQuilo(p, quantidade);
        }
        
        this.inventario.add(item);
       
       
    }

    public Set<ItemEstoque> getInventario() {
        return inventario;
    }
    
    public boolean vazio(){
        return inventario.isEmpty();
    }
    
}
