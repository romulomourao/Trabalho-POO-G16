package model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author romul
 */
public class Venda {

    
    private final String idDaVenda, cpfCliente, cpfFuncionario;
    private final String numeroDoCaixa;
    private final double valorTotal;
    private final Data data;
    private Pagamento pagamento;
    private final java.util.Set<ItemDeVenda> itensComprados;

    public Venda(String numeroDoCaixa, String cpfFuncionario, String cpfCliente, double total, Map<String,ItemDeVenda> conjuntoDositens, Pagamento pagamento) {
        this.data = new Data();
        this.valorTotal = total;
        this.numeroDoCaixa = numeroDoCaixa;
        this.cpfCliente = cpfCliente;
        this.cpfFuncionario = cpfFuncionario;
        this.idDaVenda = this.data.getAno() + this.data.getMes()+this.data.getDia()+this.data.getHorarioJunto()+"-"+numeroDoCaixa;
        this.itensComprados = conjunto(conjuntoDositens);
        this.pagamento = pagamento;
 
        
    }

    public Set<ItemDeVenda> getVenda() {
        return itensComprados;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Data getData() {
        return data;
    }


    private Set<ItemDeVenda> conjunto(Map<String, ItemDeVenda> conjuntoDositens) {
        
        Set<ItemDeVenda> resp = new HashSet<>();
        
        for (String item : conjuntoDositens.keySet()) {
            resp.add(conjuntoDositens.get(item));
        }
        return resp;
    }



}
