/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import model.Inventario;
import model.ItemDeRelatorio;
import model.ItemEstoque;
import model.OperacaoNoBanco;
import model.Produto;
import model.Relatorio;

/**
 *
 * @author romulo
 */
public class EventoBotaoInventario implements ActionListener {

  

    @Override
    public void actionPerformed(ActionEvent e) {
        Inventario inventario = OperacaoNoBanco.getInstance().invetarioDeEstoque();
         if (inventario.vazio()) {
            JOptionPane.showMessageDialog(null, "Não há nada no estoque.");
        }
        geraInventario(inventario);
    }

    private void geraInventario(Inventario inventario) {
        String codigo, nome, marca, categoria, preco, novaLinha, quantidade;
        int qtd;
    
        try {
            FileWriter fw = new FileWriter("relatorios/inventario.html");
            for (String line : Files.readAllLines(Paths.get("relatorios/start-inventario.txt"))) {
                fw.write(line);
            }
            Produto produto;
            for (ItemEstoque item : inventario.getInventario()) {
                produto = item.getProduto();
                
                codigo = "<td class=\"codigo\">" + produto.getCodigo() + "</td>";
                nome = "<td class=\"nome\">" + produto.getNome() + "</td>";
                marca = "<td class=\"marca\">" + produto.getMarca() + "</td>";
                categoria = "<td class=\"categoria\">" + produto.getCategoria() + "</td>";
                preco = "<td class=\"preco\">" + produto.getPreco() + "</td>";
                if(produto.isUnitario()){
                    quantidade = "<td class=\"quantidade\">" + item.getQuantidade() + " unidade(s)</td>";   
                }else{
                    qtd = (item.getQuantidade()/1000);
                    quantidade = "<td class=\"quantidade\">" + qtd + " Kg</td>";
                }
                             
                novaLinha = "<tr>" + codigo + nome + marca + categoria + preco + quantidade + "</tr>";
                fw.write(novaLinha);

            }

            String end = "</tbody>\n"
                    + "	  </table>\n"
                    + "\n"
                    + "	</div>\n"
                    + "		\n"
                    + "	</div>\n"
                    + "	<script src=\"list.js\"></script>\n"
                    + "	<script src=\"entradaInventario.js\"></script>\n"
                    + "</body>\n"
                    + "</html>";
            fw.write(end);
            fw.close();

            String diretorio = System.getProperty("user.dir");
            Runtime.getRuntime().exec("firefox " + diretorio + "/relatorios/inventario.html");

        } catch (IOException e) {
            return;
        }

    }

}
