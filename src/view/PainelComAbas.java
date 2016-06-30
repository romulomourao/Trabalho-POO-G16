/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author romulo
 */
public class PainelComAbas extends JTabbedPane {

    public PainelComAbas() {
        this.cria();
        this.design();
    }

    private void design() {
        this.setForeground(Color.decode("#212121"));
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setBackgroundAt(0, Color.decode("#607D8B"));
        this.setBackgroundAt(1, Color.decode("#607D8B"));
        this.setBackgroundAt(2, Color.decode("#607D8B"));
        
       
               
        
    }

    private void cria() {
        this.addTab("Consulta de Preço", new PainelInterno(new BorderLayout(),true));
        this.addTab("Realizar Venda", new PainelInterno(new BorderLayout(),true));
        this.addTab("Painel Administrativo", new PainelInterno(new BorderLayout(),true));
    }

}
