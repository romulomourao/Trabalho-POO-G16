/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.PainelDeUsuario;

/**
 *
 * @author romulo
 */
public class EventoMudarFuncionarioECaixa implements ActionListener{

    private PainelDeUsuario painelDeUsuario;
    private final JPanel painelSuperior;

    public EventoMudarFuncionarioECaixa(PainelDeUsuario painelDeUsuario, JPanel painelSuperior) {
        this.painelDeUsuario = painelDeUsuario;
        this.painelSuperior = painelSuperior;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       painelDeUsuario.alterar();
        System.out.println(painelDeUsuario.getUsuario());
        System.out.println(painelDeUsuario.getCaixa());
   
       
    }
    
}
