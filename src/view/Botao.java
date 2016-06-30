/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author romulo
 */
public class Botao extends JButton {

    private String cor = "#8BC34A";
    private boolean show = true;
    public Botao() {
        this.design();
    }
    
     public Botao(int borda) {
        this.design();
        setBorder(new EmptyBorder(borda, borda, borda, borda));
    }

    public Botao(String text, boolean show) {
        super(text);
        this.show = show;
        this.design();
    }

    public Botao(String text) {
        super(text);
        this.design();

    }

    public Botao(String text, String cor) {
        super(text);
        this.cor = cor;
        this.design();

    }

    private void design() {
        this.setFocusPainted(false);
        this.setVisible(this.show);
        this.setBackground(Color.decode(this.cor));
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setForeground(Color.white);

    }

}
