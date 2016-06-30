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
public class PagamentoNoCartao extends Pagamento {

    public PagamentoNoCartao(double valor, int parcelas) {
        super("CARTÃO", valor, parcelas);

    }

    @Override
    public void realizaOperacao(double recebido) {
        int parcelas = this.getParcelas();
        ImageIcon icone = new ImageIcon("img/notes.png");
        double valorDasParcelas = (this.getValor() / parcelas);
        JOptionPane.showMessageDialog(null, "PAGAMENTO EM " + parcelas + "x de " + valorDasParcelas + "\nTOTAL: " + String.format("%.2f", this.getValor()), "PAGAMENTO NO CARTÃO", JOptionPane.OK_OPTION, icone);
    }
}
