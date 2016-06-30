/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EventoConsultarProduto;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author romulo
 */
public class PainelDeConsulta extends PainelInterno {

    private JTextArea texto;
    private JTextField barraConsulta;

    public PainelDeConsulta() {
        super(new BorderLayout(5, 5),true);
        textoProdutoEncontrado();
        barraDeConsulta();      
    }

    
    private void textoProdutoEncontrado() {
        texto = new Texto("", 50, 100, 100, "#607D8B");
        this.add(texto, BorderLayout.CENTER);
    }

    private void barraDeConsulta() {
        barraConsulta  = new CampoDeTexto("", "#00796B");
        EventoConsultarProduto novaConsulta = new EventoConsultarProduto(texto, barraConsulta);
        barraConsulta.addKeyListener(novaConsulta);
        this.add(barraConsulta, BorderLayout.PAGE_START);
        
    }
}
