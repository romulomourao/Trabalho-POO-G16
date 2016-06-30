/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author romulo
 */
public class Texto extends JTextArea {

    private final int tamanho;
    private int vertical = 100;
    private int horizontal = 100;
    private String cor = "#009688";

    public Texto(String text, int tamanho) {
        super(text);
        this.tamanho = tamanho;
        this.design();
    }

    public Texto(String text, int tamanho, int vertical, int horizontal, String cor) {
        super(text);
        this.cor = cor;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.tamanho = tamanho;
        this.design();
    }

    private void design() {
        this.setEditable(false);
        this.setLineWrap(true);
        this.setBackground(Color.decode(this.cor));
        this.setFont(new Font("Arial", Font.BOLD, this.tamanho));
        this.setForeground(Color.white);
        this.setMargin(new Insets(vertical, horizontal, vertical, horizontal));

    }

    @Override
    public void setText(String t) {
        super.setText(t); //To change body of generated methods, choose Tools | Templates.
    }
    
   

}
