/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author romulo
 */
public class PagamentoNoDinheiro extends Pagamento {

    public PagamentoNoDinheiro(double valor) {
        super("DINHEIRO", valor);
        
    }

    @Override
    public void realizaOperacao(double recebido) {        
        if(recebido > this.getValor()){
            double troco = recebido - this.getValor();
            ImageIcon icone = new ImageIcon("img/notes.png");           
            JOptionPane.showMessageDialog(null, "TOTAL: "+String.format("%.2f", this.getValor())+"\nRECEBIDO: "+recebido+"\n TROCO: "+String.format("%.2f", troco), "PAGAMENTO EM DINHEIRO", JOptionPane.OK_OPTION, icone);
        }
    }
    
}
