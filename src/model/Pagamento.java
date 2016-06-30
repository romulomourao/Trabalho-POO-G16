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
public abstract class Pagamento {
    private String formaDePagamento;
    private double valor;
    private int parcelas;

    public Pagamento(String formaDePagamento, double valor, int parcelas) {
        this.formaDePagamento = formaDePagamento;
        this.valor = valor;
        this.parcelas = parcelas;
    }
    
    public Pagamento(String formaDePagamento, double valor) {
        this.formaDePagamento = formaDePagamento;
        this.valor = valor;
        this.parcelas = 0;
    }
    
    public abstract void realizaOperacao(double recebido);

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public double getValor() {
        return valor;
    }

    public int getParcelas() {
        return parcelas;
    }
    
    
    
    
}
