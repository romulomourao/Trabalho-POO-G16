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
public class Usuarios implements Block<Document> {

    private java.util.Set<Funcionario> usuarios;

    public Usuarios() {
        usuarios = new HashSet<>();
    }

    @Override
    public void apply(Document document) {
        String nome, cpf;
        nome = document.getString("nome");
        cpf = document.getString("cpf");
        Funcionario funcionario = new Funcionario(nome, cpf);
        usuarios.add(funcionario);
    }

    public Set<Funcionario> getUsuarios() {
        return usuarios;
    }
    
    
}
