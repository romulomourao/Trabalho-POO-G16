/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author romulo
 */
public class PainelDeUsuario extends PainelInterno {

    private String nomeUsuario, numeroCaixa, cpfCliente;
    private JTextArea usuarioHeader;

    public PainelDeUsuario() {
        this.cpfCliente = "";
        usuario();
        informacaoHeader();

    }

    PainelDeUsuario(BorderLayout borderLayout, boolean b) {
        this.cpfCliente = "";
        usuario();
        informacaoHeader();
    }

    private void usuario() {
        
        String[] caixas = {"1", "2", "3"};
        String[] usuarios = {"Romulo", "Igor", "Suelen"};
        ImageIcon icone = new ImageIcon("img/user.png");
        nomeUsuario = (String) JOptionPane.showInputDialog(null, "FUNCIONARIO:", "JAVA SUPERMERCADO", JOptionPane.OK_OPTION, icone, usuarios, usuarios[0]);
        icone = new ImageIcon("img/cashier.png");
        numeroCaixa = (String) JOptionPane.showInputDialog(null, "CAIXA:", "JAVA SUPERMERCADO", JOptionPane.OK_OPTION, icone, caixas, caixas[0]);
        if (numeroCaixa == null) {
            System.exit(0);
        }

        //ir na lista de funcionarios
        JOptionPane.showMessageDialog(null, "Seja Bem-Vindo, " + nomeUsuario + "\n\nVocê está no CAIXA Nº " + numeroCaixa);
        // Funcionario usuario = new Funcionario(nome, cpf);
    }

    private void informacaoHeader() {
        usuarioHeader = new Texto("FUNCIONARIO: " + nomeUsuario + "\nCAIXA: " + numeroCaixa+ "\nCLIENTE: " + cpfCliente, 14, 20, 20, "#03A9F4");
        this.add(usuarioHeader, 0);
        // this.add(usuarioHeader, BorderLayout.CENTER);
    }

    public String getUsuario() {
        return this.nomeUsuario;
    }

    public String getCaixa() {
        return this.numeroCaixa;
    }
    
     public String getCliente() {
        return this.cpfCliente; 
    }

    public JTextArea getHeader() {
        return usuarioHeader;
    }

    public void alterar() {
        usuario();
        usuarioHeader.setText("FUNCIONARIO: " + nomeUsuario + "\nCAIXA: " + numeroCaixa);
        this.repaint();
    }

    public void setarCliente() {
        this.cpfCliente = JOptionPane.showInputDialog("CPF CLIENTE: ");
        usuarioHeader.setText("FUNCIONARIO: " + nomeUsuario + "\nCAIXA: " + numeroCaixa + "\nCLIENTE: " + cpfCliente);
        this.repaint();
    }
    
     public void zerarCliente() {
        this.cpfCliente = "";
        usuarioHeader.setText("FUNCIONARIO: " + nomeUsuario + "\nCAIXA: " + numeroCaixa + "\nCLIENTE: " + cpfCliente);
        this.repaint();
    }

}
