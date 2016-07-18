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
public class ItemDeRelatorio {

    private final String idDaVenda;
    private final String horario;
    private final String numeroDoCaixa;
    private final String nomeFuncionario;
    private final double valorTotal;

    ItemDeRelatorio(String idDaVenda, String horario, String numeroDoCaixa, String nomeFuncionario, double valorTotal) {
        this.idDaVenda = idDaVenda;
        this.horario = horario;
        this.numeroDoCaixa = numeroDoCaixa;
        this.nomeFuncionario = nomeFuncionario;
        this.valorTotal = valorTotal;
        
    }

    public String getIdDaVenda() {
        return idDaVenda;
    }

    public String getHorario() {
        return horario;
    }

    public String getNumeroDoCaixa() {
        return numeroDoCaixa;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    
    
}
