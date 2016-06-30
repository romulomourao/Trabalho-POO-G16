/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author romulo
 */
public class Label extends JLabel {

    private int tamanho;

    public Label(String text, int horizontalAlignment, int tamanho) {
        super(text, horizontalAlignment);
        this.tamanho = tamanho;
        this.design();
    }

    public Label(String texto) {

        super(texto);
        this.tamanho = 20;
        this.design();
    }

    public Label(String texto, int tamanho) {

        super(texto);
        this.tamanho = tamanho;
        this.design();
    }

    public Label(int tamanho) {

        super();
        this.tamanho = tamanho;
        this.design();
    }

    public Label() {

        super();
        this.tamanho = 20;
        this.design();
    }

    private void design() {
        this.setFont(new Font("Arial", Font.PLAIN, this.tamanho));
        this.setForeground(Color.white);

    }

}
