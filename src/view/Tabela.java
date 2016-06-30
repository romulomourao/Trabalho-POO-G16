/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

/**
 *
 * @author romulo
 */
public class Tabela extends JTable {

    public Tabela(TableModel dm) {
        super(dm);
        this.design();
    }

    @Override
    public boolean isCellEditable(int row, int column) {

        return false;
    }

    private void design() {
        this.setBorder(new LineBorder(Color.white, 1));
        this.setGridColor(Color.white);
        this.setShowGrid(true);
        this.setBackground(Color.decode("#F57C00"));
        this.setDragEnabled(false);
        
        this.setFont(new Font("Arial", Font.BOLD, 12));
        this.setForeground(Color.white);

    }

}
