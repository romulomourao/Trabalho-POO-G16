/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mongodb.Block;
import model.Caixas;
import model.Funcionario;
import model.OperacaoNoBanco;
import model.Usuarios;
import org.bson.Document;

/**
 *
 * @author romulo
 */
public class DadosDeAcesso {

    private Usuarios usuarios;
    private Caixas caixas;
    

    public DadosDeAcesso() {
        
    }

    public String[] getUsersName() {
        this.usuarios = OperacaoNoBanco.getInstance().getUsers();
        int qtd = usuarios.getUsuarios().size();
        String[] resp = new String[qtd];
        int i = 0;
        for (Funcionario f : usuarios.getUsuarios()) {
            resp[i] = f.getNome();
            i++;
        }
        return resp;
    }
    
     public String[] getCaixas() {
        this.caixas = OperacaoNoBanco.getInstance().getCaixas();     
        int qtd = caixas.getCaixas().size();
        String[] resp = new String[qtd];
        int i = 0;
        for (String caixa : caixas.getCaixas()) {
            resp[i] = caixa;
            i++;
        }
        return resp;
    }

}
