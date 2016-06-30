/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EventoConsultarProduto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import model.Estoque;

/**
 *
 * @author romulo
 */
public class PainelInterno extends JPanel {

    private Boolean temMargem = false;
    private int bordaHorizontal =10 ;
    private int bordaVertical= 10 ;

    public PainelInterno(LayoutManager layout, Boolean temMargem) {
        super(layout);
        this.temMargem = temMargem;
        this.color();
        
    }
    

    public PainelInterno(LayoutManager layout, int vertical, int horizontal) {
        super(layout);       
        this.bordaHorizontal = horizontal;
        this.bordaVertical = vertical;
        this.color();
    }

    public PainelInterno() {
        super(new GridLayout());
        this.setBackground(Color.decode("#455A64"));
    }
 
    private void color() {
        this.setBackground(Color.decode("#263238"));
        if(temMargem){
            this.setBorder(new EmptyBorder(this.bordaVertical, this.bordaHorizontal, this.bordaVertical, this.bordaHorizontal));
        }
        
    }

  

}
