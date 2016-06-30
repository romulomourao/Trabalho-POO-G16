/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author romulo
 */
public class CampoDeTexto extends JTextField {

    private String cor = "#009688";
    private int tamanho = 50;
    private int vertical = 5;
    private int horizontal = 40;
    

    public CampoDeTexto() {
        this.design();
    }

    public CampoDeTexto(String text) {
        super(text);
        this.design();
    }

    public CampoDeTexto(int tamanho) {
        super();
        this.tamanho = tamanho;
        this.design();
    }

    public CampoDeTexto(String text, String cor) {
        super(text);
        this.cor = cor;
        this.design();
    }

    public CampoDeTexto(String text, int tamanho) {
        super(text);
        this.tamanho = tamanho;
        this.vertical=1;
        this.horizontal=1;
        this.design();
    }

    public CampoDeTexto(String text, String cor, int tamanho) {
        super(text);
        this.tamanho = tamanho;
        this.cor = cor;
        this.design();
    }

    private void design() {
        this.setFont(new Font("Arial", Font.PLAIN, this.tamanho));
        this.setForeground(Color.white);
        this.setBackground(Color.decode(this.cor));
        this.setBorder(new EmptyBorder(vertical,horizontal,vertical,horizontal));
    }

}
