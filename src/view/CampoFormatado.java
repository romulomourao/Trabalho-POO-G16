/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.text.Format;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author romulo
 */
public class CampoFormatado extends JFormattedTextField {

    private String cor = "#009688";
    private int tamanho = 50;


    public CampoFormatado(int tamanho) {
        this.tamanho = tamanho;
        this.design();
    }

    public CampoFormatado(Format format,int tamanho) {
        super(format);
        this.tamanho = tamanho;
        this.design();
    }

    public CampoFormatado(Object value) {
        super(value);
        this.design();
    }

    public CampoFormatado(Format format) {
        super(format);
        this.design();
    }
    

    public CampoFormatado(AbstractFormatter formatter) {
        super(formatter);

        this.tamanho = tamanho;
        this.design();
    }

    private void design() {
        this.setFont(new Font("Arial", Font.PLAIN, this.tamanho));
        this.setForeground(Color.white);
        this.setBackground(Color.decode(this.cor));
        this.setBorder(new EmptyBorder(5, 40, 5, 40));
    }



}
