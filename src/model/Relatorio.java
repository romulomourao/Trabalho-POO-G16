/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mongodb.Block;
import java.util.HashSet;
import java.util.Set;
import static javafx.scene.input.KeyCode.T;
import org.bson.Document;

/**
 *
 * @author romulo
 */
public class Relatorio implements Block<Document> {

    private java.util.Set<ItemDeRelatorio> relatorio;
    private double total = 0;

    public Relatorio() {
        this.relatorio = new HashSet();
    }

    public void addItemDeRelatorio(ItemDeRelatorio item) {
        relatorio.add(item);
    }

    @Override
    public void apply(Document document) {
        String nomeFuncionario, numeroDoCaixa, idDaVenda, hora;
        double valorTotal;
        nomeFuncionario = document.getString("nomeFuncionario");
        numeroDoCaixa = document.getString("numeroDoCaixa");
        Document horario = (Document) document.get("data");
        hora = horario.getString("horario"); 
        idDaVenda = document.getString("idDaVenda");
        valorTotal = document.getDouble("valorTotal");
        total += valorTotal;
        ItemDeRelatorio item = new ItemDeRelatorio(idDaVenda, hora, numeroDoCaixa, nomeFuncionario, valorTotal);
        this.relatorio.add(item);
    }
    
    public boolean vazio(){
        return relatorio.isEmpty();        
    }

    public Set<ItemDeRelatorio> getRelatorio() {
        return relatorio;
    }

    public double getTotal() {
        return total;
    }
    
    
    

}
