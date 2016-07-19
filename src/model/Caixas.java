/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mongodb.Block;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.bson.Document;

/**
 *
 * @author romulo
 */
public class Caixas implements Block<Document> {

    private java.util.Set<String> caixas;

    public Caixas() {
        caixas = new HashSet<>();
    }

    @Override
    public void apply(Document document) {
        String numeroDoCaixa;
        numeroDoCaixa = document.getString("numeroDoCaixa");
        caixas.add(numeroDoCaixa);
    }

    public Set<String> getCaixas() {
        return caixas;
    }
    
    
}
