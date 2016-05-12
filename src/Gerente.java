/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romul
 */
public class Gerente extends Funcionario{
    
    private String login;
    private String senha;
    
    public Gerente(String nome, String cpf, String senha) {
        super(nome,cpf,true);
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
