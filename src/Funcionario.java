/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romul
 */
public class Funcionario {

    private String nome;
    private String cpf;
    private boolean privilegios;

    public Funcionario(String nome, String cpf, boolean privilegios) {
        this.nome = nome;
        this.cpf = cpf;
        this.privilegios = privilegios;
        
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
 
    public boolean getPrivilegios() {
        return privilegios;
    }
 
    
    

}
